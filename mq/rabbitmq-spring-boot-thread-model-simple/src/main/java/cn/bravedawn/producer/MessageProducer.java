package cn.bravedawn.producer;

import cn.bravedawn.mq.RabbitmqConfig;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                // if(ack){
                //     System.out.println(correlationData.getId()+" ack is: true! 消息发送成功");
                // }else {
                //     System.out.println(correlationData.getId()+" ack is: false! 消息发送失败");
                // }
            }
        });
    }


    public void sendMessage(String message) {

        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE, RabbitmqConfig.ROUTING_KEY,
                message, new CorrelationData(UUID.randomUUID().toString()));

        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE, RabbitmqConfig.ROUTING_KEY_2,
                message, new CorrelationData(UUID.randomUUID().toString()));
    }

}
