package cn.bravedawn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.amqp.rabbit.retry.RepublishMessageRecovererWithConfirms;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.interceptor.RetryOperationsInterceptor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author : depers
 * @program : rabbitmq-spring-boot-retry-demo
 * @date : Created in 2024/6/18 14:28
 */

@Configuration
@Slf4j
public class RabbitConfig {

    @Value("${mq.queueBinding.queue}")
    private String queueName;
    @Value("${mq.queueBinding.exchange.name}")
    private String exchangeName;
    @Value("${mq.queueBinding.key}")
    private String key;


    /**
     * 业务队列
     */
    @Bean
    public Queue payQueue(){
        Map<String,Object> params = new HashMap<>();
        return QueueBuilder.durable(queueName).withArguments(params).build();

    }

    /**
     * 交换机
     */
    @Bean
    public DirectExchange payTopicExchange(){
        return new DirectExchange(exchangeName,true,false);
    }

    /**
     * 队列与交换机进行绑定
     */
    @Bean
    public Binding BindingPayQueueAndPayTopicExchange(Queue payQueue, DirectExchange payTopicExchange){
        return BindingBuilder.bind(payQueue).to(payTopicExchange).with(key);
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory,
                                                                               RetryOperationsInterceptor retryOperationsInterceptor) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        factory.setGlobalQos(false);
        factory.setConcurrentConsumers(2);
        factory.setMaxConcurrentConsumers(2);
        factory.setPrefetchCount(10);
        factory.setAdviceChain(retryOperationsInterceptor);
        return factory;
    }

        @Bean
    public RetryOperationsInterceptor retryOperationsInterceptor(){
        return RetryInterceptorBuilder.stateless()
                .maxAttempts(3)
                .backOffOptions(1000, 3.0, 10000)
                .recoverer(new CallBackExhaustedRecover(getConsumer()))
                .build();
    }

    private BiConsumer<String, Throwable> getConsumer() {
        return (msg, e) -> {
            log.info("消息出现异常，已达上限，msg={}, e={}", msg, e);
        };
    }

}
