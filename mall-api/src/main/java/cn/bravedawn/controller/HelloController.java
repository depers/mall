package cn.bravedawn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 冯晓
 * @Date 2019/12/26 20:18
 */
@RestController
public class HelloController {


    @GetMapping("/hello")
    public Object hello(){
        return "hello world~";
    }
}
