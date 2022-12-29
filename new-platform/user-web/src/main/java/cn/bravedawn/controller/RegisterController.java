package cn.bravedawn.controller;

import cn.bravedawn.MemberRepository;
import cn.bravedawn.entity.Member;
import cn.bravedawn.web.mvc.controller.Controller;
import cn.bravedawn.web.mvc.controller.PageController;
import cn.bravedawn.web.mvc.controller.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.PrintWriter;

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
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        MemberRepository memberRepository = new MemberRepository();
        Member member = new Member();
        member.setUsername(username);
        member.setEmail(email);
        Member user = memberRepository.selectOne(member);

        if (user != null) {
            return "该用户已注册";
        } else {
            memberRepository.save(member);
            // 数据库相关逻辑
            return "注册成功";
        }
    }

}
