package cn.bravedawn.mq;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.interceptor.RetryOperationsInterceptor;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
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

    // 第三种：配置SimpleRabbitListenerContainerFactory演示simple配置模型
    public static final String QUEUE = "simple-queue-consumer";
    public static final String QUEUE_2 = "simple-queue-consumer-2";

    // 第二种：通过配置SimpleRabbitListenerContainer来监听消息
    public static final String CONTAINER_QUEUE = "simple-container-queue";
    public static final String CONTAINER_QUEUE_2 = "simple-container-queue-2";

    // 第二种：通过在application.yml中配置simple Listener
    public static final String UNIFY_QUEUE = "unify-simple-queue-consumer";
    public static final String UNIFY_QUEUE_2 = "unify-simple-queue-consumer-2";
    public static final String EXCHANGE = "simple-exchange";
    public static final String UNIFY_EXCHANGE = "unify-simple-exchange";
    public static final String CONTAINER_EXCHANGE = "container-exchange";
    public static final String ROUTING_KEY = "simple-routing-key";
    public static final String ROUTING_KEY_2 = "simple-routing-key-2";
    public static final String UNIFY_ROUTING_KEY = "unify-simple-routing-key";
    public static final String UNIFY_ROUTING_KEY_2 = "unify-simple-routing-key-2";
    public static final String CONTAINER_ROUTING_KEY = "container-routing-key";
    public static final String CONTAINER_ROUTING_KEY_2 = "container-routing-key-2";

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
        rabbitAdmin.declareQueue(new Queue(UNIFY_QUEUE_2, true, false, false));
        rabbitAdmin.declareQueue(new Queue(CONTAINER_QUEUE, true, false, false));
        rabbitAdmin.declareQueue(new Queue(CONTAINER_QUEUE_2, true, false, false));
        rabbitAdmin.declareExchange(new DirectExchange(EXCHANGE, true, false));
        rabbitAdmin.declareExchange(new DirectExchange(UNIFY_EXCHANGE, true, false));
        rabbitAdmin.declareExchange(new DirectExchange(CONTAINER_EXCHANGE, true, false));
        rabbitAdmin.declareBinding(new Binding(QUEUE, Binding.DestinationType.QUEUE, EXCHANGE, ROUTING_KEY, new HashMap<>()));
        rabbitAdmin.declareBinding(new Binding(QUEUE_2, Binding.DestinationType.QUEUE, EXCHANGE, ROUTING_KEY_2, new HashMap<>()));
        rabbitAdmin.declareBinding(new Binding(UNIFY_QUEUE, Binding.DestinationType.QUEUE, UNIFY_EXCHANGE, UNIFY_ROUTING_KEY, new HashMap<>()));
        rabbitAdmin.declareBinding(new Binding(UNIFY_QUEUE_2, Binding.DestinationType.QUEUE, UNIFY_EXCHANGE, UNIFY_ROUTING_KEY_2, new HashMap<>()));
        rabbitAdmin.declareBinding(new Binding(CONTAINER_QUEUE, Binding.DestinationType.QUEUE, CONTAINER_EXCHANGE, CONTAINER_ROUTING_KEY, new HashMap<>()));
        rabbitAdmin.declareBinding(new Binding(CONTAINER_QUEUE_2, Binding.DestinationType.QUEUE, CONTAINER_EXCHANGE, CONTAINER_ROUTING_KEY_2, new HashMap<>()));
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

    /**
     * 队列simple-queue-consumer和simple-queue-consumer-2对使用这个工厂类来生成并发容器
     * @param connectionFactory
     * @param onceRetryInterceptor
     * @return
     */
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


    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.addQueueNames(CONTAINER_QUEUE);
        container.addQueueNames(CONTAINER_QUEUE_2);
        // 设置默认 consumer 数为3
        container.setConcurrentConsumers(2);
        // 设置最大 consumer 数为4
        container.setMaxConcurrentConsumers(2);
        // 设置每个消费者代确认的消息数量
        container.setPrefetchCount(10);
        // 是否以Channel维度来设置PrefetchCount，若为true的话就是以消费者
        container.setGlobalQos(false);
        // 标记 consumerTag
        container.setConsumerTagStrategy(queue -> "consumer" + (index.incrementAndGet()));
        // 设置手动确认
        container.setAcknowledgeMode(AcknowledgeMode.AUTO);
        // 配置消费者
        container.setMessageListener(new MessageListenerAdapter() {

            @Override
            protected Object[] buildListenerArguments(Object extractedMessage, Channel channel, Message message) {
                return new Object[]{extractedMessage, channel, message};
            }

            @Override
            protected String getListenerMethodName(Message originalMessage, Object extractedMessage) {

                if (originalMessage.getMessageProperties().getConsumerQueue().equals(CONTAINER_QUEUE)) {
                    return "consumer1";
                }

                if (originalMessage.getMessageProperties().getConsumerQueue().equals(CONTAINER_QUEUE_2)) {
                    return "consumer2";
                }
                return null;
            }

            public void consumer1(String msg, Channel channel, Message message) throws IOException {
                Thread thread = Thread.currentThread();
                log.info("Channel:" + channel.getChannelNumber()
                        + "  ThreadId is:" + thread.getId()
                        + "  ConsumerTag:" + message.getMessageProperties().getConsumerTag()
                        + "  Queue:" + message.getMessageProperties().getConsumerQueue()
                        + "  msg:" + msg);
            }

            public void consumer2(String msg, Channel channel, Message message) {
                Thread thread = Thread.currentThread();
                log.info("Channel:" + channel.getChannelNumber()
                        + "  ThreadId is:" + thread.getId()
                        + "  ConsumerTag:" + message.getMessageProperties().getConsumerTag()
                        + "  Queue:" + message.getMessageProperties().getConsumerQueue()
                        + "  msg:" + msg);
            }
        });

        return container;
    }



}
