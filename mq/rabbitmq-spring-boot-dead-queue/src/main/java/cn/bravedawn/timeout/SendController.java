package cn.bravedawn.timeout;

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
        rabbitTemplate.convertAndSend(Config.exchangeA, Config.routingKeyA,
                "延时消息a", new CorrelationData(UUID.randomUUID().toString()));

        rabbitTemplate.convertAndSend(Config.exchangeB, Config.routingKeyB,
                "延时消息b", new CorrelationData(UUID.randomUUID().toString()));
        log.info("发送消息到交换机");
        return "success";
    }
}
