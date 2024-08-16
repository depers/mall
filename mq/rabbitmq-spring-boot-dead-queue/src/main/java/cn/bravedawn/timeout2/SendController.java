package cn.bravedawn.timeout2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author : depers
 * @program : rabbitmq-spring-boot-dead-queue
 * @date : Created in 2024/8/5 13:53
 */

@RestController
@Slf4j
public class SendController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("send")
    public String send() {
        rabbitTemplate.convertAndSend(Config.exchangeC, Config.routingKeyC,
                "延时消息c", new CorrelationData(UUID.randomUUID().toString()));
        log.info("发送消息到交换机");
        return "success";
    }
}
