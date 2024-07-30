package cn.bravedawn.config;

import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : rabbitmq-spring-boot-demo
 * @date : Created in 2024/4/23 15:17
 */

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "exchange";
    public static final String QUEUE_NAME = "queue";
    public static final String ROUTING_KEY = "test";

    // 自动创建就是靠他
    // 开启懒加载，不然会有循环依赖问题
    @Autowired
    private RabbitAdmin rabbitAdmin;

    @PostConstruct
    public void init() {
        rabbitAdmin.declareQueue(createQueue());
        rabbitAdmin.declareExchange(createExchange());
        rabbitAdmin.declareBinding(createBinding());
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        rabbitAdmin.setAutoStartup(true);
        return rabbitAdmin;
    }

    public Exchange createExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    public Queue createQueue() {
        // 配置声明队列时使用的参数
        Map<String, Object> args = new HashMap<>(1);
        // // 设置死信队列指向的交换机
        // args.put("x-dead-letter-exchange", EXCHANGE_DLX);
        // args.put("x-dead-letter-routing-key", KEY_DLX);
        // // 设置队列内消息过期时间，单位：毫秒
        // args.put("x-message-ttl", 15000);

        return new Queue(QUEUE_NAME, true, false, false, args);
    }


    public Binding createBinding() {
        // 目的地名称、目的地类型、绑定交换机、绑定 key、参数
        return new Binding(QUEUE_NAME, Binding.DestinationType.QUEUE, EXCHANGE_NAME, ROUTING_KEY, null);
    }


}
