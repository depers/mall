package cn.bravedawn.controller;

import cn.bravedawn.bo.ShopcartBO;
import cn.bravedawn.bo.UserBO;
import cn.bravedawn.pojo.Users;
import cn.bravedawn.service.UserService;
import cn.bravedawn.utils.*;
import cn.bravedawn.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author 冯晓
 * @Date 2020/1/3 19:43
 */
@Api(value = "注册登录", tags = {"用于注册登录的相关接口"})
@RestController
@RequestMapping("passport")
public class PassportController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private RedisOperator redisOperator;

    @ApiOperation(value = "用户名是否存在", notes = "用户名是否存在", httpMethod = "GET")
    @GetMapping("usernameIsExist")
    public JsonResult usernameIsExist(@RequestParam String username){
        // 1.对请求参数进行判空操作
        if (StringUtils.isBlank(username)){
            return JsonResult.errorMsg("用户名不能为空");
        }

        // 2.查询数据库用户是否存在
        boolean isExist = userService.queryUserNameIsExist(username);
        if (isExist){
            return JsonResult.errorMsg("用户存在");
        }

        // 3.用户不存在返回200
        return JsonResult.ok();
    }


    @ApiOperation(value = "用户注册", notes = "用户注册", httpMethod = "POST")
    @PostMapping("/regist")
    public JsonResult regist(@RequestBody UserBO userBO,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {

        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPwd = userBO.getConfirmPassword();

        // 0. 判断用户名和密码必须不为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password) ||
                StringUtils.isBlank(confirmPwd)) {
            return JsonResult.errorMsg("用户名或密码不能为空");
        }

        // 1. 查询用户名是否存在
        boolean isExist = userService.queryUserNameIsExist(username);
        if (isExist) {
            return JsonResult.errorMsg("用户名已经存在");
        }

        // 2. 密码长度不能少于6位
        if (password.length() < 6) {
            return JsonResult.errorMsg("密码长度不能少于6");
        }

        // 3. 判断两次密码是否一致
        if (!password.equals(confirmPwd)) {
            return JsonResult.errorMsg("两次密码输入不一致");
        }

        // 4. 实现注册
        Users userResult = userService.createUser(userBO);

        // 5. 信息脱敏
        // userResult = setNullProperty(userResult);

        // 4. 生成用户token，存入redis会话
        UserVO userVO = conventUser(userResult);

        // 6. 添加cookie信息
        CookieUtils.setCookie(request, response, "user",
                JsonUtils.objectToJson(userVO), true);

        // 同步购物车数据
        syncShopCartData(userResult.getId(), request, response);

        return JsonResult.ok();
    }

    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "POST")
    @PostMapping("/login")
    public JsonResult login(@RequestBody UserBO userBO,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        String username = userBO.getUsername();
        String password = userBO.getPassword();

        // 0. 判断用户名和密码必须不为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password)) {
            return JsonResult.errorMsg("用户名或密码不能为空");
        }

        // 1. 实现登录
        Users userResult = userService.queryUserForLogin(username,
                MD5Utils.getMD5Str(password));

        if (userResult == null) {
            return JsonResult.errorMsg("用户名或密码不正确");
        }

        // 2. 信息脱敏
        // userResult = setNullProperty(userResult);

        // 4. 生成用户token，存入redis会话
        UserVO userVO = conventUser(userResult);

        // 5. 添加cookie信息
        CookieUtils.setCookie(request, response, "user",
                JsonUtils.objectToJson(userVO), true);

        // 同步购物车数据
        syncShopCartData(userResult.getId(), request, response);

        return JsonResult.ok(userResult);
    }

    /**
     * 注册登录成功后，同步cookie和redis中的购物车数据
     */
    private void syncShopCartData(String userId, HttpServletRequest request,
                                  HttpServletResponse response){
        /**
         * 1. redis中无数据，如果cookie中的购物车为空，那么这个时候不做任何处理
         *                  如果cookie中的购物车不为空，此时直接将cookie中的数据放入redis
         * 2. redis中有数据，如果cookie中的购物车为空，那么直接把redis的购物车数据覆盖到本地cookie中
         *                  如果cookie中购物车不为空，
         *                      如果cookie中的某个商品在redis中存在，
         *                          则以cookie为主，删除redis中的，把cookie中的商品直接覆盖到redis中（参考京东）
         * 3. 同步到redis中去了之后，覆盖本地cookie购物车的数据，保证本地购物车的数据是同步最新的
         */

        // 1.获取购物车中的redis数据
        String shopCartValueRedis = redisOperator.get(FOODIE_SHOPCART + ":" + userId);

        // 2. 获取cookie中的购物车数据
        String shopCartValueCookie = CookieUtils.getCookieValue(request, FOODIE_SHOPCART, true);

        if (StringUtils.isBlank(shopCartValueRedis)){
            // redis中为空，cookie不为空，直接把cookie中的数据放入redis
            if (StringUtils.isNotBlank(shopCartValueCookie)){
                redisOperator.set(FOODIE_SHOPCART + ":" + userId, shopCartValueCookie);
            }
        }else{
            // redis不为空，cookie不为空，合并cookie和redis中购物车的商品数据（同一商品则覆盖redis）
            if (StringUtils.isNotBlank(shopCartValueCookie)){
                /**
                 * 1. 已经存在的，把cookie中对于的数量，覆盖redis（参考京东）
                 * 2. redis中有而redis中没有的商品，该项商品标记为待删除，同一放入一个待删除的list
                 * 3. 从cookie中清理所有的待删除list
                 * 4. 合并redis和cookie中的数据
                 * 5. 更新到redis和cookies中
                 */

                List<ShopcartBO> shopCartListRedis = JsonUtils.jsonToList(shopCartValueRedis, ShopcartBO.class);
                List<ShopcartBO> shopCartListCookie = JsonUtils.jsonToList(shopCartValueCookie, ShopcartBO.class);

                // 定义一个待删除list
                List<ShopcartBO> pendingDeleteList = new ArrayList<>();

                for (ShopcartBO redisShopCart : shopCartListRedis){
                    String redisSpecId = redisShopCart.getSpecId();

                    for (ShopcartBO cookieShopCart : shopCartListCookie){
                        String cookieSpecId = redisShopCart.getSpecId();

                        if (redisSpecId.equals(cookieSpecId)){
                            // 覆盖购买数量，不累加（参考京东）
                            redisShopCart.setBuyCounts(cookieShopCart.getBuyCounts());

                            // 把cookieShopCart放入待删除列表，用于最后的删除与合并
                            pendingDeleteList.add(cookieShopCart);
                        }
                    }
                }
                // 从现有cookie中删除对应的股改过的商品数据
                shopCartListCookie.removeAll(pendingDeleteList);
                // 合并两个list
                shopCartListRedis.addAll(shopCartListCookie);
                // 更新redis和cookie
                redisOperator.set(FOODIE_SHOPCART + ":" + userId, JsonUtils.objectToJson(shopCartListRedis));
                CookieUtils.setCookie(request, response, FOODIE_SHOPCART, JsonUtils.objectToJson(shopCartListRedis), true);
            } else{
                // redis不为空，cookie为空，直接把redis覆盖cookie
                CookieUtils.setCookie(request, response, FOODIE_SHOPCART, shopCartValueRedis, true);
            }
        }
    }


    @ApiOperation(value = "用户退出登录", notes = "用户退出登录", httpMethod = "POST")
    @PostMapping("/logout")
    public JsonResult logout(@RequestParam String userId,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {

        // 清除用户的相关信息的cookie
        CookieUtils.deleteCookie(request, response, "user");

        // 用户退出登录，清除redis中user的会话信息
        redisOperator.del(REDIS_USER_TOKEN + ":" + userId);

        // 用户退出登录，需要清空购物车
        CookieUtils.deleteCookie(request, response, FOODIE_SHOPCART);

        return JsonResult.ok();
    }

    private Users setNullProperty(Users userResult) {
        userResult.setPassword(null);
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedTime(null);
        userResult.setBirthday(null);
        return userResult;
    }
}
