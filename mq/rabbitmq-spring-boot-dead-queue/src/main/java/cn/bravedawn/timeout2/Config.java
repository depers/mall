package cn.bravedawn.timeout2;

import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
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

    public static final String queueNameC = "c-queue";
    public static final String routingKeyC = "c-routing-key";
    public static final String exchangeC = "c-exchange";

    public static final String deadQueue = "dead-queue";
    public static final String deadRoutingKey = "dead-routing-key";
    public static final String deadExchange = "dead-exchange";

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @PostConstruct
    public void init() {
        Map<String, Object> args = new HashMap<>();
        // x-dead-letter-exchange 这里声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", deadExchange);
        // x-dead-letter-routing-key 这里声明当前队列的死信路由key
        args.put("x-dead-letter-routing-key", deadRoutingKey);

        rabbitAdmin.declareQueue(new Queue(queueNameC, true, false, false, args));
        rabbitAdmin.declareExchange(new DirectExchange(exchangeC, true, false));
        rabbitAdmin.declareBinding(new Binding(queueNameC, Binding.DestinationType.QUEUE, exchangeC, routingKeyC, new HashMap<>()));


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

    @Bean
    public MessageConverter messageConverter() {
        return new MessageConverter() {
            @Override
            public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
                Jackson2JsonMessageConverter jsonMessageConverter = new Jackson2JsonMessageConverter();
                messageProperties.setExpiration("10000");
                return jsonMessageConverter.toMessage(object, messageProperties);
            }

            @Override
            public Object fromMessage(Message message) throws MessageConversionException {
                Jackson2JsonMessageConverter jsonMessageConverter = new Jackson2JsonMessageConverter();
                return jsonMessageConverter.fromMessage(message);
            }
        };
    }
}
