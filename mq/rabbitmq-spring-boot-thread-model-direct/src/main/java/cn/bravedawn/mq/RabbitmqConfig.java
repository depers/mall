package cn.bravedawn.mq;

import com.rabbitmq.client.Channel;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.AbstractConnectionFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.DirectMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.ConnectionFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

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

    public static final String QUEUE = "direct-queue-1";
    public static final String QUEUE_2 = "direct-queue-2";
    public static final String EXCHANGE = "direct-exchange";
    public static final String ROUTING_KEY = "direct-1";
    public static final String ROUTING_KEY_2 = "direct-2";

    private AtomicInteger index = new AtomicInteger(0);

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        rabbitAdmin.setAutoStartup(true);
        return rabbitAdmin;
    }

    @Bean
    public DirectMessageListenerContainer messageContainer(CachingConnectionFactory connectionFactory) {

        DirectMessageListenerContainer container = new DirectMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        // 绑定Queue1/Queue2
        container.addQueueNames(QUEUE);
        container.addQueueNames(QUEUE_2);
        // 设置每个队列消费者的数量
        container.setConsumersPerQueue(10);

        container.setPrefetchCount(50);
        container.setGlobalQos(false);
        // 标记 consumerTag
        container.setConsumerTagStrategy(queue -> "consumer" + (index.incrementAndGet()));
        // 设置自动确认
        container.setAcknowledgeMode(AcknowledgeMode.AUTO);

        // 设置消费者线程池
        setExecutor(connectionFactory);

        // 创建队列
        createQueue();


        // 绑定ChannelAwareMessageListener显示接收信息
        container.setMessageListener(new ChannelAwareMessageListener() {
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                Thread thread = Thread.currentThread();
                log.info("Channel:" + channel.getChannelNumber()
                        + "  ThreadId is:" + thread.getId()
                        + "  ConsumerTag:" + message.getMessageProperties().getConsumerTag()
                        + "  Queue:" + message.getMessageProperties().getConsumerQueue());

                Thread.sleep(2000);
            }
        });
        return container;
    }

    public void createQueue() {
        // 创建队列、交换机和绑定关系
        rabbitAdmin.declareQueue(new Queue(QUEUE, true, false, false));
        rabbitAdmin.declareQueue(new Queue(QUEUE_2, true, false, false));
        rabbitAdmin.declareExchange(new DirectExchange(EXCHANGE, true, false));
        rabbitAdmin.declareBinding(new Binding(QUEUE, Binding.DestinationType.QUEUE, EXCHANGE, ROUTING_KEY, new HashMap<>()));
        rabbitAdmin.declareBinding(new Binding(QUEUE_2, Binding.DestinationType.QUEUE, EXCHANGE, ROUTING_KEY_2, new HashMap<>()));
    }

    public void setExecutor(CachingConnectionFactory connectionFactory) {
        // 设置消息者线程池没有用
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setMaxPoolSize(10);
        threadPoolTaskExecutor.setThreadNamePrefix("rabbitmq-");
        threadPoolTaskExecutor.initialize();
        connectionFactory.setExecutor(threadPoolTaskExecutor);
    }



}
