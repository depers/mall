package cn.bravedawn.controller;

import cn.bravedawn.producer.ReturnMsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : depers
 * @program : rabbitmq-spring-boot-demo
 * @date : Created in 2024/4/23 14:52
 */

@RestController
public class SendController {

    @Autowired
    private ReturnMsgProducer returnMsgProducer;

    @GetMapping("/sendReturn")
    public String send() {
        returnMsgProducer.send();
        return "success";
    }
}
