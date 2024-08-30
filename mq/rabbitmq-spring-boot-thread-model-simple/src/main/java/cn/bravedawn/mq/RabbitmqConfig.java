package cn.bravedawn.mq;

import com.rabbitmq.client.Channel;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

    public static final String QUEUE = "simple-queue-1";
    public static final String QUEUE_2 = "simple-queue-2";
    public static final String EXCHANGE = "simple-exchange";
    public static final String ROUTING_KEY = "simple-1";
    public static final String ROUTING_KEY_2 = "simple-2";

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
        rabbitAdmin.declareExchange(new DirectExchange(EXCHANGE, true, false));
        rabbitAdmin.declareBinding(new Binding(QUEUE, Binding.DestinationType.QUEUE, EXCHANGE, ROUTING_KEY, new HashMap<>()));
        rabbitAdmin.declareBinding(new Binding(QUEUE_2, Binding.DestinationType.QUEUE, EXCHANGE, ROUTING_KEY_2, new HashMap<>()));
    }


    /**
     * 通过设置MessageListener进行消息的消费
     * @param connectionFactory
     * @return
     */
    @Bean
    public SimpleMessageListenerContainer messageContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        // 绑定Queue1/Queue2
        container.addQueueNames(QUEUE);
        container.addQueueNames(QUEUE_2);
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
        // 绑定ChannelAwareMessageListener显示接收信息
        container.setMessageListener(new ChannelAwareMessageListener() {
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                Thread thread = Thread.currentThread();
                log.info("Channel:" + channel.getChannelNumber()
                        + "  ThreadId is:" + thread.getId()
                        + "  ConsumerTag:" + message.getMessageProperties().getConsumerTag()
                        + "  Queue:" + message.getMessageProperties().getConsumerQueue());

                Thread.sleep(100);
            }
        });
        return container;
    }


}
