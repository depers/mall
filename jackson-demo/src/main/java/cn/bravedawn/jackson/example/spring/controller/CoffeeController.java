package cn.bravedawn.jackson.example.spring.controller;

import cn.bravedawn.jackson.example.spring.pojo.Coffee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author : depers
 * @program : jackson-demo
 * @description: 咖啡控制层
 * @date : Created in 2021/11/6 13:32
 */
@RestController
public class CoffeeController {

    @GetMapping("/coffee")
    public Coffee getCoffee(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String name) {
        return new Coffee()
                .setBrand(brand)
                .setDate(LocalDateTime.now())
                .setName(name);
    }

}
