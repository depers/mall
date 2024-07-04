package cn.bravedawn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.amqp.rabbit.retry.RepublishMessageRecovererWithConfirms;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

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
        // params.put("x-dead-letter-exchange", "errorTopicExchange");
        // params.put("x-dead-letter-routing-key", "error");
        return QueueBuilder.durable(queueName).withArguments(params).build();

    }

    /**
     * 交换机
     */
    @Bean
    public TopicExchange payTopicExchange(){
        return new TopicExchange(exchangeName,true,false);
    }

    /**
     * 队列与交换机进行绑定
     */
    @Bean
    public Binding BindingPayQueueAndPayTopicExchange(Queue payQueue, TopicExchange payTopicExchange){
        return BindingBuilder.bind(payQueue).to(payTopicExchange).with(key);
    }

    // @Bean
    // public Queue errorQueue(){
    //     Map<String,Object> params = new HashMap<>();
    //     return QueueBuilder.durable("errorQueue").withArguments(params).build();
    // }
    //
    // @Bean
    // public TopicExchange errorTopicExchange(){
    //     return new TopicExchange("errorTopicExchange",true,false);
    // }
    //
    // @Bean
    // public Binding BindingErrorQueueAndErrorTopicExchange(Queue errorQueue, TopicExchange errorTopicExchange){
    //     return BindingBuilder.bind(errorQueue).to(errorTopicExchange).with("error");
    // }




}
