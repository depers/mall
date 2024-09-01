package cn.bravedawn.autoprefetch;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author : depers
 * @program : rabbitmq-spring-boot-prefetch
 * @date : Created in 2024/9/1 10:05
 */
@RestController
public class RabbitController {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @GetMapping("send")
    public String send() {

        for (int i = 0; i < 1000; i++) {
            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY,
                    "发送消息", new CorrelationData(UUID.randomUUID().toString()));
        }
        return "success";
    }
}
