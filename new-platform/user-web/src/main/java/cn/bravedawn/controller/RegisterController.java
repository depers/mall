package cn.bravedawn.controller;

import cn.bravedawn.web.mvc.controller.Controller;
import cn.bravedawn.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @author : depers
 * @program : new-platform
 * @description:
 * @date : Created in 2022/11/22 22:29
 */

@Path("app")
public class RegisterController implements PageController {


    @POST
    @Path("register")
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable{
        // 数据库相关逻辑
        return "register_success.jsp";
    }

}
