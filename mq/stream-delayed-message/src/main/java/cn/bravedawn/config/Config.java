package cn.bravedawn.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : stream-delayed-message
 * @date : Created in 2024/5/7 11:13
 */

@Configuration
@Slf4j
public class Config {

    public static final String TOPIC_EXCHANGE_NAME = "delay-msg-exchange";
    public static final String QUEUE_NAME = "delay-msg-queue";
    public static final String ROUTING_KEY = "delay.#";
    public static final String DEAD_LETTER_EXCHANGE_NAME = "delay-dead-letter-exchange";
    public static final String DEAD_LETTER_QUEUE_NAME = "delay-dead-letter-queue";
    public static final String DEAD_LETTER_ROUTING_KEY = "delay-dead-letter.#";


    // 声明业务交换机
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }

    // 声明死信交换机
    @Bean
    public TopicExchange topicExchangeDLK() {
        return new TopicExchange(DEAD_LETTER_EXCHANGE_NAME);
    }

    // 声明死信队列
    @Bean
    public Queue delayMsgQueueDLK() {
        return new Queue(DEAD_LETTER_QUEUE_NAME, true, false, false);
    }

    // 绑定业务队列和交换机
    @Bean
    public Binding bindingDelayMsgQueue() {
        // 目的地名称、目的地类型、绑定交换机、绑定 key、参数
        return new Binding(QUEUE_NAME, Binding.DestinationType.QUEUE, TOPIC_EXCHANGE_NAME, ROUTING_KEY, null);
    }


    // 声明业务队列
    @Bean
    public Queue delayMsgQueue() {
        Map<String, Object> args = new HashMap<>();
        // x-dead-letter-exchange 这里声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", DEAD_LETTER_EXCHANGE_NAME);
        // x-dead-letter-routing-key 这里声明当前队列的死信路由key
        args.put("x-dead-letter-routing-key", DEAD_LETTER_ROUTING_KEY);
        return new Queue(QUEUE_NAME, true, false, false, args);
    }


    // 绑定死信队列和交换机
    @Bean
    public Binding bindingDeadLetterDelayMsgQueue() {
        // 目的地名称、目的地类型、绑定交换机、绑定 key、参数
        return new Binding(DEAD_LETTER_QUEUE_NAME, Binding.DestinationType.QUEUE, DEAD_LETTER_EXCHANGE_NAME, DEAD_LETTER_ROUTING_KEY, null);
    }

    /**
     * 设置发送消息的序列化配置
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if (ack) {
                    log.info("消息已发送到交换机");
                } else {
                    log.error("消息未发送到交换机");
                }
            }
        });
        return rabbitTemplate;
    }


    /**
     * 设置接收消息的序列化配置
     * @return
     */
    // @Bean
    // public MessageConverter messageConverter() {
    //     return new Jackson2JsonMessageConverter();
    // }

}
