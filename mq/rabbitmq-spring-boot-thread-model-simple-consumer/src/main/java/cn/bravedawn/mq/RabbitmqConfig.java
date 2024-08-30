package cn.bravedawn.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.interceptor.RetryOperationsInterceptor;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : depers
 * @program : rabbitmq-spring-boot-thread-model
 * @date : Created in 2024/7/3 17:30
 */

@Configuration
@Slf4j
public class RabbitmqConfig {

    @Autowired
    private RabbitAdmin rabbitAdmin;

    public static final String QUEUE = "simple-queue-consumer";
    public static final String QUEUE_2 = "simple-queue-consumer-2";
    public static final String UNIFY_QUEUE = "unify-simple-queue-consumer";
    public static final String EXCHANGE = "simple-exchange";
    public static final String UNIFY_EXCHANGE = "unify-simple-exchange";
    public static final String ROUTING_KEY = "simple-routing-key";
    public static final String ROUTING_KEY_2 = "simple-routing-key";
    public static final String UNIFY_ROUTING_KEY = "unify-simple-routing-key";

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
        rabbitAdmin.declareQueue(new Queue(QUEUE_2, true, false, false));
        rabbitAdmin.declareQueue(new Queue(UNIFY_QUEUE, true, false, false));
        rabbitAdmin.declareExchange(new DirectExchange(EXCHANGE, true, false));
        rabbitAdmin.declareExchange(new DirectExchange(UNIFY_EXCHANGE, true, false));
        rabbitAdmin.declareBinding(new Binding(QUEUE, Binding.DestinationType.QUEUE, EXCHANGE, ROUTING_KEY, new HashMap<>()));
        rabbitAdmin.declareBinding(new Binding(QUEUE_2, Binding.DestinationType.QUEUE, EXCHANGE, ROUTING_KEY_2, new HashMap<>()));
        rabbitAdmin.declareBinding(new Binding(UNIFY_QUEUE, Binding.DestinationType.QUEUE, UNIFY_EXCHANGE, UNIFY_ROUTING_KEY, new HashMap<>()));
    }


    @Bean("rabbitMqTemplate")
    public RabbitTemplate rabbitMqTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
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
        return rabbitTemplate;
    }

    /**
     * 声明消息的重试机制
     * @return
     */
    @Bean
    public RetryOperationsInterceptor retryInterceptor() {
        return RetryInterceptorBuilder.stateless()
                .maxAttempts(3)
                .backOffOptions(1000, 3.0, 10000)
                .recoverer(messageRecover())
                .build();
    }


    /**
     * 声明消息的重试机制
     * @return
     */
    @Bean
    public RetryOperationsInterceptor onceRetryInterceptor() {
        return RetryInterceptorBuilder.stateless()
                .maxAttempts(1)
                .recoverer(messageRecover())
                .build();
    }

    @Bean("simpleContainerFactory")
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(ConnectionFactory connectionFactory,
                                                                                     RetryOperationsInterceptor onceRetryInterceptor) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        factory.setGlobalQos(false);
        factory.setConcurrentConsumers(2);
        factory.setMaxConcurrentConsumers(2);
        factory.setPrefetchCount(10);
        factory.setConsumerTagStrategy(queue -> "consumer" + (index.incrementAndGet()));

        factory.setAdviceChain(onceRetryInterceptor);

        return factory;
    }


    /**
     * 消息到达最大重试次数的处理逻辑
     * @return
     */
    public MessageRecoverer messageRecover() {
        return new MessageRecoverer() {
            @Override
            public void recover(Message message, Throwable cause) {
                log.warn("消息重试执行失败, msg={}, cause={}", message.getBody(), cause);
            }
        };
    }



}
