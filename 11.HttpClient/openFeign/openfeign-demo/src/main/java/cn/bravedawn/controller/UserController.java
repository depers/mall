package cn.bravedawn.controller;

import cn.bravedawn.model.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : openfeign-demo
 * @description:
 * @date : Created in 2022/12/15 15:58
 */

@RestController
@Slf4j
public class UserController {

    @RequestMapping("/register")
    public Map register(@RequestBody Post post) {
        log.info("请求参数：param={}.", post);
        Map<String, String> result = new HashMap<>();
        result.put("status", "success");
        result.put("code", "200");
        return result;
    }
}
