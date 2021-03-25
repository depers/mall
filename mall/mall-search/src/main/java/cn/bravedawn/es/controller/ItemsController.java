package cn.bravedawn.es.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : depers
 * @program : mall
 * @description: 商品搜索
 * @date : Created in 2021/1/31 11:09
 */
@RequestMapping
@RestController
public class ItemsController {

    @GetMapping("hello")
    public String hello(){
        return "hello es";
    }
}
