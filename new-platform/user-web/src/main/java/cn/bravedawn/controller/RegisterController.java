package cn.bravedawn.controller;

import cn.bravedawn.MemberRepository;
import cn.bravedawn.entity.Member;
import cn.bravedawn.web.mvc.controller.Controller;
import cn.bravedawn.web.mvc.controller.PageController;
import cn.bravedawn.web.mvc.controller.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;

/**
 * @author : depers
 * @program : new-platform
 * @description:
 * @date : Created in 2022/11/22 22:29
 */

@Path("app")
public class RegisterController implements RestController {

    @POST
    @Path("register")
    public String register(HttpServletRequest request, HttpServletResponse response) throws Throwable{
        StringBuffer sb = new StringBuffer();
        ServletInputStream inputStream = request.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = "";
        while ((str = bufferedReader.readLine()) != null) {
            sb.append(str);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        Member member = objectMapper.readValue(sb.toString(), Member.class);
        MemberRepository memberRepository = new MemberRepository();
        Member user = memberRepository.selectOne(member);

        System.out.println("用户信息为：" + user);

        if (user != null) {
            return "该用户已注册";
        } else {
            memberRepository.save(member);
            // 数据库相关逻辑
            return "注册成功";
        }
    }

}
