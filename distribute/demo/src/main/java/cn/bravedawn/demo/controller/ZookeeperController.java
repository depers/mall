package cn.bravedawn.demo.controller;

import cn.bravedawn.demo.lock.ZkLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author : depers
 * @program : demo
 * @description: zookeeper
 * @date : Created in 2021/6/6 10:17
 */
@RestController
@Slf4j
public class ZookeeperController {

    @RequestMapping("zkLock")
    public String zookeeperLock() {
        log.info("我进入了方法！");
        try (ZkLock zkLock = new ZkLock()){
            if (zkLock.getLock("order")) {
                log.info("我获得了锁！");
                Thread.sleep(10000);
            } else {
                log.info("没有获得锁，等待中！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("方法执行完成！");
        return "方法执行完成！";
    }
}
