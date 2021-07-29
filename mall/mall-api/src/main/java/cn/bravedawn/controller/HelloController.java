package cn.bravedawn.controller;

import cn.bravedawn.mapper.StuMapperCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.nio.charset.Charset;
import java.security.PublicKey;
import java.util.HashMap;

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

    @GetMapping("getType")
    public HashMap getType(HttpServletRequest request, HttpServletResponse response){
        HashMap map = new HashMap();
        map.put("name", "全渠道");
        response.setContentType("application/json;charset=UTF-8");
        return map;
    }


}
