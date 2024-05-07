package cn.bravedawn.consumer;

import cn.bravedawn.config.Config;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @author : depers
 * @program : stream-delayed-message
 * @date : Created in 2024/5/7 11:11
 */

@RestController
public class ProducerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static final String routingKey = "delay.#";


    @GetMapping("/send")
    public String send() {
        MessageProperties properties = new MessageProperties();
        properties.setExpiration("4294967296"); // 这个值可以设置的足够大

        Message message = new Message("hello".getBytes(StandardCharsets.UTF_8), properties);
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(Config.TOPIC_EXCHANGE_NAME, "delay.1", message, correlationData);
        return "success";
    }
}
