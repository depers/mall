package cn.bravedawn.controller;

import cn.bravedawn.annotation.CheckIdempotent;
import cn.bravedawn.bo.ShopcartBO;
import cn.bravedawn.bo.SubmitOrderBO;
import cn.bravedawn.enums.OrderStatusEnum;
import cn.bravedawn.enums.PayMethod;
import cn.bravedawn.pojo.OrderStatus;
import cn.bravedawn.service.OrderService;
import cn.bravedawn.utils.CookieUtils;
import cn.bravedawn.utils.JsonResult;
import cn.bravedawn.utils.JsonUtils;
import cn.bravedawn.utils.RedisOperator;
import cn.bravedawn.vo.MerchantOrdersVO;
import cn.bravedawn.vo.OrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author 冯晓
 * @Date 2020/1/19 22:38
 */
@Api(value = "订单相关", tags = {"订单相关的api接口"})
@RequestMapping("orders")
@RestController
@Slf4j
public class OrderController extends BaseController{

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisOperator redisOperator;

    @CheckIdempotent
    @ApiOperation(value = "用户下单", notes = "用户下单", httpMethod = "POST")
    @PostMapping("/create")
    public JsonResult create(@RequestBody SubmitOrderBO submitOrderBO,
                             HttpServletRequest request,
                             HttpServletResponse response){

        log.info(submitOrderBO.toString());
        // 对支付方式进行判断
        if (submitOrderBO.getPayMethod() != PayMethod.WEIXIN.type
                && submitOrderBO.getPayMethod() != PayMethod.ALIPAY.type ) {
            return JsonResult.errorMsg("支付方式不支持！");
        }

        // 查询购物车
        String shopCartJson = redisOperator.get(FOODIE_SHOPCART + ":" + submitOrderBO.getUserId());
        if (StringUtils.isBlank(shopCartJson)){
            return JsonResult.errorMsg("购物车数据不正确");
        }
        List<ShopcartBO> shopcartList = JsonUtils.jsonToList(shopCartJson, ShopcartBO.class);

        // 1.创建订单
        OrderVO orderVO = orderService.createOrder(shopcartList, submitOrderBO);
        String orderId = orderVO.getOrderId();

        // 2.创建订单以后，移除购物车中已结算（已提交）的商品
        // 清理覆盖现有的redis汇总的购物车数据
        shopcartList.removeAll(orderVO.getToBeRemovedShopcartList());
        redisOperator.set(FOODIE_SHOPCART + ":" + submitOrderBO.getUserId(), JsonUtils.objectToJson(shopcartList));

        // 整合redis之后，完善购物车中的已结算商品清除，并且同步到前端的cookie
        CookieUtils.setCookie(request, response, FOODIE_SHOPCART, JsonUtils.objectToJson(shopcartList), true);

        // 3.向支付中心发送当前订单，用于保存支付中心的订单数据
        MerchantOrdersVO merchantOrdersVO = orderVO.getMerchantOrdersVO();
        merchantOrdersVO.setReturnUrl(payReturnUrl);

        // 为了方便测试购买，所以所有的支付金额都统一改为1分钱
        merchantOrdersVO.setAmount(1);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("imoocUserId","imooc");
        headers.add("password","imooc");

        HttpEntity<MerchantOrdersVO> entity =
                new HttpEntity<>(merchantOrdersVO, headers);

        ResponseEntity<JsonResult> responseEntity =
                restTemplate.postForEntity(paymentUrl,
                        entity,
                        JsonResult.class);
        JsonResult paymentResult = responseEntity.getBody();
        if (paymentResult.getStatus() != 200) {
            log.error("发送错误：{}", paymentResult.getMsg());
            return JsonResult.errorMsg("支付中心订单创建失败，请联系管理员！");
        }

        return JsonResult.ok(orderId);
    }

    @PostMapping("notifyMerchantOrderPaid")
    public Integer notifyMerchantOrderPaid(String merchantOrderId) {
        orderService.updateOrderStatus(merchantOrderId, OrderStatusEnum.WAIT_DELIVER.type);
        return HttpStatus.OK.value();
    }

    @PostMapping("getPaidOrderInfo")
    public JsonResult getPaidOrderInfo(String orderId) {
        OrderStatus orderStatus = orderService.queryOrderStatusInfo(orderId);
        return JsonResult.ok(orderStatus);
    }
}
