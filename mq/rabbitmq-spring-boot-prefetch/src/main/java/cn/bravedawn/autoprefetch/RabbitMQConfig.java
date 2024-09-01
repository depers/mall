package cn.bravedawn.autoprefetch;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : depers
 * @program : rabbitmq-spring-boot-prefetch
 * @date : Created in 2024/9/1 09:54
 */

@Configuration
public class RabbitMQConfig {

    @Autowired
    private RabbitAdmin rabbitAdmin;

    public static final String QUEUE = "auto-prefetch";
    public static final String EXCHANGE = "auto-prefetch";
    public static final String ROUTING_KEY = "auto-prefetch";

    private AtomicInteger index = new AtomicInteger(0);


    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        rabbitAdmin.setAutoStartup(true);
        return rabbitAdmin;
    }

    @PostConstruct
    public void init() {
        rabbitAdmin.declareQueue(new Queue(QUEUE, true, false, false));
        rabbitAdmin.declareExchange(new DirectExchange(EXCHANGE, true, false));
        rabbitAdmin.declareBinding(new Binding(QUEUE, Binding.DestinationType.QUEUE, EXCHANGE, ROUTING_KEY, new HashMap<>()));
    }

    @Bean("simpleFactory")
    public SimpleRabbitListenerContainerFactory SimpleRabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        // 配置mq消费端消费能力的关键参数，就是下面的4个
        factory.setGlobalQos(false);
        factory.setConcurrentConsumers(5);
        factory.setMaxConcurrentConsumers(5);
        factory.setPrefetchCount(10);
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        factory.setConsumerTagStrategy(queue -> "consumer" + (index.incrementAndGet()));
        return factory;
    }
}
