package cn.bravedawn.producer;

import cn.bravedawn.mq.RabbitmqConfig;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author : depers
 * @program : rabbitmq-spring-boot-thread-model
 * @date : Created in 2024/7/3 18:10
 */

@Component
@Slf4j
public class MessageProducer {

    @Autowired
    @Qualifier("rabbitMqTemplate")
    private RabbitTemplate rabbitTemplate;


    public void sendMessage(String message) {

        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE, RabbitmqConfig.ROUTING_KEY,
                message, new CorrelationData(UUID.randomUUID().toString()));

        // rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE, RabbitmqConfig.ROUTING_KEY_2,
        //         message, new CorrelationData(UUID.randomUUID().toString()));
    }

}
