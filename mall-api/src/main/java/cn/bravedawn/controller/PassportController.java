package cn.bravedawn.controller;

import cn.bravedawn.bo.UserBO;
import cn.bravedawn.pojo.Users;
import cn.bravedawn.service.UserService;
import cn.bravedawn.utils.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author 冯晓
 * @Date 2020/1/3 19:43
 */
@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @GetMapping("usernameIsExist")
    public JsonResult usernameIsExist(@RequestParam String username){
        // 1.对请求参数进行判空操作
        if (StringUtils.isBlank(username)){
            return JsonResult.errorMsg("用户名不能为空");
        }

        // 2.查询数据库用户是否存在
        boolean isExist = userService.queryUserNameIsExist(username);
        if (isExist){
            return JsonResult.errorMsg("用户不存在");
        }

        // 3.用户不存在返回200
        return JsonResult.ok();
    }


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

        return JsonResult.ok();
    }
}
