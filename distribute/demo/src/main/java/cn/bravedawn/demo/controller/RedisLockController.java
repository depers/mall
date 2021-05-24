package cn.bravedawn.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : depers
 * @program : demo
 * @description: RedisLock
 * @date : Created in 2021/5/24 19:56
 */

@RestController
@Slf4j
public class RedisLockController {

    @Autowired
//    private RedisT

    @RequestMapping("redisLock")
    public String redisLock() {
        log.info("我进入了方法");
        return "";
    }

}
