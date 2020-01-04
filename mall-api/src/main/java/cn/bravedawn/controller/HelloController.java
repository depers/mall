package cn.bravedawn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Author 冯晓
 * @Date 2019/12/26 20:18
 */
@ApiIgnore
@RestController
public class HelloController {


    @GetMapping("/hello")
    public Object hello(){
        return "hello world~";
    }
}
