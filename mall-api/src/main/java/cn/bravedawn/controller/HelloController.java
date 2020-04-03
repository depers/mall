package cn.bravedawn.controller;

import cn.bravedawn.mapper.StuMapperCustom;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private StuMapperCustom stuMapperCustom;

    private String name = stuMapperCustom.getDBString();

    @GetMapping("/hello")
    public Object hello(){
        System.out.println("---------------------"+name);
        return "hello world~";
    }
}
