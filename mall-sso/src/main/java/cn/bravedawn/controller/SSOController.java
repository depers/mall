package cn.bravedawn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author 冯晓
 * @Date 2019/12/26 20:18
 */
@Controller
public class SSOController {


    @GetMapping("/hello")
    public Object hello(){
        return "hello world~";
    }

}
