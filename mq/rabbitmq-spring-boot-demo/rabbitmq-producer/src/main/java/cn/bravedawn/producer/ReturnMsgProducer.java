package cn.bravedawn.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : rabbitmq-spring-boot-demo
 * @date : Created in 2024/4/23 14:23
 */

@Component
@Slf4j
public class ReturnMsgProducer {

    /**
     * 测试Return模式下配置为true的情况下，broker没有将消息路由到队列，生产者端是否会对其进行ack
     */


    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE_NAME = "exchange.cat";
    private static final String ROUTING_KEY = "return";


    public void send() {
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (ack) {
                log.info("成功将消息发送到了exchange");
            } else {
                log.error(
                        "没有将消息发送到exchange! correlationData: {}, cause: {}",
                        correlationData,
                        cause);
            }
        });
        rabbitTemplate.setReturnsCallback(returned -> {
            log.error("The message sent has no corresponding queue! Returned message: {}", returned);
        });
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, "hello, return msg");
    }
}
