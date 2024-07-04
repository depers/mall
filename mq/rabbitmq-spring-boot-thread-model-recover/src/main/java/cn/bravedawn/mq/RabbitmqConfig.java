package cn.bravedawn.mq;

import com.rabbitmq.client.Channel;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.amqp.rabbit.retry.RepublishMessageRecovererWithConfirms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.interceptor.RetryInterceptorBuilder;
import org.springframework.retry.interceptor.RetryOperationsInterceptor;

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

    public static final String QUEUE = "recover-queue";
    public static final String ERROR_QUEUE = "recover-error-queue";
    public static final String EXCHANGE = "recover-exchange";
    public static final String ERROR_EXCHANGE = "recover-error-exchange";
    public static final String ROUTING_KEY = "recover";
    public static final String ERROR_ROUTING_KEY = "recover-error";

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
        rabbitAdmin.declareQueue(new Queue(ERROR_QUEUE, true, false, false));
        rabbitAdmin.declareExchange(new DirectExchange(EXCHANGE, true, false));
        rabbitAdmin.declareExchange(new DirectExchange(ERROR_EXCHANGE, true, false));
        rabbitAdmin.declareBinding(new Binding(QUEUE, Binding.DestinationType.QUEUE, EXCHANGE, ROUTING_KEY, new HashMap<>()));
        rabbitAdmin.declareBinding(new Binding(ERROR_QUEUE, Binding.DestinationType.QUEUE, ERROR_EXCHANGE, ERROR_ROUTING_KEY, new HashMap<>()));
    }

    @Bean
    public MessageRecoverer messageRecoverer(ConnectionFactory connectionFactory) {
        return new RepublishMessageRecovererWithConfirms(rabbitTemplate(connectionFactory), ERROR_EXCHANGE, ERROR_ROUTING_KEY, CachingConnectionFactory.ConfirmType.CORRELATED);
    }


    @Bean("errorRabbitMQTemplate")
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                log.info("消息重试的confirm方法");
            }
        });
        return rabbitTemplate;
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



}
