package cn.bravedawn.timeout;

import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : rabbitmq-spring-boot-dead-queue
 * @date : Created in 2024/8/5 13:37
 */

@Configuration

public class Config {

    public static final String queueNameA = "a-queue";
    public static final String queueNameB = "b-queue";
    public static final String routingKeyA = "a-routing-key";
    public static final String routingKeyB = "b-routing-key";
    public static final String exchangeA = "a-exchange";
    public static final String exchangeB = "b-exchange";

    public static final String deadQueue = "dead-queue";
    public static final String deadRoutingKey = "dead-routing-key";
    public static final String deadExchange = "dead-exchange";

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @PostConstruct
    public void init() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-message-ttl", 30000);
        // x-dead-letter-exchange 这里声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", deadExchange);
        // x-dead-letter-routing-key 这里声明当前队列的死信路由key
        args.put("x-dead-letter-routing-key", deadRoutingKey);

        rabbitAdmin.declareQueue(new Queue(queueNameA, true, false, false, args));
        rabbitAdmin.declareQueue(new Queue(queueNameB, true, false, false, args));
        rabbitAdmin.declareExchange(new DirectExchange(exchangeA, true, false));
        rabbitAdmin.declareExchange(new DirectExchange(exchangeB, true, false));
        rabbitAdmin.declareBinding(new Binding(queueNameA, Binding.DestinationType.QUEUE, exchangeA, routingKeyA, new HashMap<>()));
        rabbitAdmin.declareBinding(new Binding(queueNameB, Binding.DestinationType.QUEUE, exchangeB, routingKeyB, new HashMap<>()));


        rabbitAdmin.declareQueue(new Queue(deadQueue, true, false, false));
        rabbitAdmin.declareExchange(new DirectExchange(deadExchange, true, false));
        rabbitAdmin.declareBinding(new Binding(deadQueue, Binding.DestinationType.QUEUE, deadExchange, deadRoutingKey, new HashMap<>()));
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        rabbitAdmin.setAutoStartup(true);
        return rabbitAdmin;
    }
}
