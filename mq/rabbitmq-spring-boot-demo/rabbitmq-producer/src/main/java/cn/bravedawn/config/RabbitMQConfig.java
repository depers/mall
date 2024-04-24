package cn.bravedawn.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : rabbitmq-spring-boot-demo
 * @date : Created in 2024/4/23 15:17
 */

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "exchange.cat";
    public static final String EXCHANGE_DLX  = "exchange.dlx";
    public static final String QUEUE_NAME    = "queue.cat";
    public static final String QUEUE_DLX     = "queue.dlx";
    public static final String KEY_NAME      = "return";
    public static final String KEY_DLX       = "#";

    @Bean
    public Exchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue queue() {
        // 配置声明队列时使用的参数
        // Map<String, Object> args = new HashMap<>(1);
        // // 设置死信队列指向的交换机
        // args.put("x-dead-letter-exchange", EXCHANGE_DLX);
        // // 设置队列内消息过期时间，单位：毫秒
        // args.put("x-message-ttl", 15000);

        return new Queue(QUEUE_NAME, true, false, false, null);
    }


    @Bean
    public Binding binding() {
        // 目的地名称、目的地类型、绑定交换机、绑定 key、参数
        return new Binding(QUEUE_NAME, Binding.DestinationType.QUEUE, EXCHANGE_NAME, KEY_NAME, null);
    }

    // @Bean
    // public TopicExchange dlxExchange() {
    //     return new TopicExchange(EXCHANGE_DLX);
    // }
    //
    // @Bean
    // public Queue dlxQueue() {
    //     return new Queue(QUEUE_DLX);
    // }
    //
    // @Bean
    // public Binding dlxBinding() {
    //     // 目的地名称、目的地类型、绑定交换机、绑定 key、参数
    //     return new Binding(QUEUE_DLX, Binding.DestinationType.QUEUE, EXCHANGE_DLX, KEY_DLX, null);
    // }
}
