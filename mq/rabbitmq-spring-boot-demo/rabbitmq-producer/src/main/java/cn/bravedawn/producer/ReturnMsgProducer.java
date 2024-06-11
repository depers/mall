package cn.bravedawn.producer;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

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

    private ObjectMapper objectMapper = new ObjectMapper();

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

        // 设置return Listener，在mandatory为true的情况下
        rabbitTemplate.setReturnsCallback(returned -> {
            log.error("The message sent has no corresponding queue! Returned message: {}", returned);
        });

        // 发送消息时的消息转换器
        rabbitTemplate.setMessageConverter(new MessageConverter() {
            @Override
            public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
                System.out.println("发送消息inner-msg-id={}" + messageProperties.getHeader("inner-msg-id"));

                try {
                    return new Message(objectMapper.writeValueAsBytes(object), messageProperties);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public Object fromMessage(Message message) throws MessageConversionException {
                try {
                    return objectMapper.readValue(message.getBody(), String.class);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, "hello, return msg");
    }
}
