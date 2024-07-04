package cn.bravedawn.controller;

import cn.bravedawn.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : depers
 * @program : rabbitmq-spring-boot-thread-model
 * @date : Created in 2024/7/3 18:30
 */

@RestController
public class SendController {

    @Autowired
    private MessageProducer messageProducer;


    @GetMapping("send")
    public String send() {
        messageProducer.sendMessage("hello!");

        return "success";
    }
}
