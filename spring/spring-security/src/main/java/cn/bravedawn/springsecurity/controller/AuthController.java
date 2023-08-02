package cn.bravedawn.springsecurity.controller;


import cn.bravedawn.springsecurity.constant.MyConstant;
import cn.bravedawn.springsecurity.model.web.SignInReq;
import cn.hutool.jwt.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("user")
public class AuthController {

    // 注入的是默认实现ProviderManager实例
    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public String login(@RequestBody SignInReq req) {
        // 构建认证信息，UsernamePasswordAuthenticationToken入参
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());

        // 交给authenticationManager去校验
        authenticationManager.authenticate(authenticationToken);

        String token = JWT.create()
                .setPayload("username", req.getUsername())
                .setKey(MyConstant.JWT_SIGN_KEY.getBytes(StandardCharsets.UTF_8))
                .sign();

        return token;
    }


    @GetMapping("/{id}")
    @PreAuthorize("has('user')")
    public String getUserDetail(@PathVariable String id) {
        return "用户详情" + id;
    }
}
