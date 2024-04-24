package cn.bravedawn.controller;

import cn.bravedawn.bo.ShopcartBO;
import cn.bravedawn.utils.JsonResult;
import cn.bravedawn.utils.JsonUtils;
import cn.bravedawn.utils.RedisOperator;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author 冯晓
 * @Date 2020/1/15 13:41
 */
@Api(value = "购物车接口controller", tags = {"购物车接口相关的api"})
@RequestMapping("shopcart")
@RestController
@Slf4j
public class ShopcartController extends BaseController{

    @Autowired
    private RedisOperator redisOperator;

    @ApiOperation(value = "添加商品到购物车", notes = "添加商品到购物车", httpMethod = "POST")
    @PostMapping("/add")
    public JsonResult add(
            @RequestParam String userId,
            @RequestBody ShopcartBO shopcartBO,
            HttpServletRequest request,
            HttpServletResponse response
    ) {

        if (StringUtils.isBlank(userId)) {
            return JsonResult.errorMsg("");
        }

        log.info(shopcartBO.toString());

        // 1. 前端用户在登录的情况下，添加商品到购物车，会同时在后端同步购物车到redis缓存
        // 2. 需要判断当前购物车中是否包含已经存在的商品，如果存在则累加购买数量
        String shopCartJson = redisOperator.get(FOODIE_SHOPCART + ":" + userId);
        List<ShopcartBO> shopcartList = null;
        if (StringUtils.isNotBlank(shopCartJson)){
            // redis中已经有购物车的数据
            shopcartList = JsonUtils.jsonToList(shopCartJson, ShopcartBO.class);

            // 判断购物车中是否存在已有的商品，如果有的话counts累加
            boolean isHaving = false;
            for (ShopcartBO sc : shopcartList){
                String tmpSpecId = sc.getSpecId();
                if (tmpSpecId.equals(shopcartBO.getSpecId())){
                    sc.setBuyCounts(sc.getBuyCounts() + shopcartBO.getBuyCounts());
                    isHaving = true;
                }
            }
            if (!isHaving) {
                shopcartList.add(shopcartBO);
            }
        } else{
            // redis中没有购物车
            shopcartList = Lists.newArrayList();
            // 直接添加到购物车
            shopcartList.add(shopcartBO);
        }

        // 覆盖现有redis中的购物车
        redisOperator.set(FOODIE_SHOPCART + ":" + userId, JsonUtils.objectToJson(shopcartList));
        return JsonResult.ok();
    }


    @ApiOperation(value = "从购物车中删除商品", notes = "从购物车中删除商品", httpMethod = "POST")
    @PostMapping("/del")
    public JsonResult del(
            @RequestParam String userId,
            @RequestParam String itemSpecId,
            HttpServletRequest request,
            HttpServletResponse response
    ) {

        if (StringUtils.isBlank(userId) || StringUtils.isBlank(itemSpecId)) {
            return JsonResult.errorMsg("参数不能为空");
        }

        // 用户在页面删除购物车中的商品数据，如果此时用户已经登录，则需要同步删除redis购物车中的商品
        String shopCartJson = redisOperator.get(FOODIE_SHOPCART + ":" + userId);
        if (StringUtils.isNotBlank(shopCartJson)){
            // redis中没有购物车数据
            List<ShopcartBO> shopcartList = JsonUtils.jsonToList(shopCartJson, ShopcartBO.class);

            // 判断购物车中是否存在已有商品，如果有的话删除
            for (ShopcartBO sc : shopcartList){
                String tmpSpecId = sc.getSpecId();
                if (tmpSpecId.equals(itemSpecId)){
                    shopcartList.remove(sc);
                    break;
                }
            }
            // 覆盖现有redis中的购物车
            redisOperator.set(FOODIE_SHOPCART + ":" + userId, JsonUtils.objectToJson(shopcartList));
        }

        return JsonResult.ok();
    }
}
