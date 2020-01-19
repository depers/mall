package cn.bravedawn.controller;

import cn.bravedawn.bo.SubmitOrderBO;
import cn.bravedawn.enums.PayMethod;
import cn.bravedawn.service.OrderService;
import cn.bravedawn.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 冯晓
 * @Date 2020/1/19 22:38
 */
@Api(value = "订单相关", tags = {"订单相关的api接口"})
@RequestMapping("orders")
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "用户下单", notes = "用户下单", httpMethod = "POST")
    @PostMapping("/create")
    public JsonResult create(@RequestBody SubmitOrderBO submitOrderBO){

        log.info(submitOrderBO.toString());
        // 对支付方式进行判断
        if (submitOrderBO.getPayMethod() != PayMethod.WEIXIN.type
                && submitOrderBO.getPayMethod() != PayMethod.ALIPAY.type ) {
            return JsonResult.errorMsg("支付方式不支持！");
        }


        // 1.创建订单
        orderService.createOrder(submitOrderBO);

        // 2.创建订单以后，移除购物车中已结算（已提交）的商品
        // 3.向支付中心发送当前订单，用于保存支付中心的订单数据

        return JsonResult.ok();
    }
}
