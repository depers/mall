package cn.bravedawn.controller;

import cn.bravedawn.mapper.StuMapperCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.PublicKey;

/**
 * @Author 冯晓
 * @Date 2019/12/26 20:18
 */
@ApiIgnore
@RestController
public class HelloController {

    @Autowired
    private StuMapperCustom stuMapperCustom;

    //private String name = stuMapperCustom.getDBString();

    @GetMapping("/hello")
    public Object hello(){
        //System.out.println("---------------------"+name);
        return "hello world~";
    }

    @GetMapping("setSession")
    public Object setSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("userInfo", "new User");
        session.setMaxInactiveInterval(3600);
        session.getAttribute("userInfo");
        return "OK";
    }


}
