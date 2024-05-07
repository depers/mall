package cn.bravedawn.producer;

import cn.bravedawn.config.Config;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author : depers
 * @program : stream-delayed-message
 * @date : Created in 2024/5/7 11:44
 */

@Component
@Slf4j
public class Consumer {

    /**
     * 正常的消费者
     * @param message
     * @param deliveryTag
     * @param channel
     * @throws IOException
     */
    // @RabbitListener(queues = Config.QUEUE_NAME)
    public void listen(@Payload Message message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {
        log.info("msg={}", message);
        log.info("deliveryTag={}", deliveryTag);
        channel.basicAck(deliveryTag, false);
    }


    /**
     * 死信队列消费者，只有在消息有效时间内内没有消费者消费这条消息，消息才会传递到死信队列
     * @param message
     * @param deliveryTag
     * @param channel
     * @throws IOException
     */
    @RabbitListener(queues = Config.DEAD_LETTER_QUEUE_NAME)
    public void listenDLK(@Payload Message message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {
        log.info("死信队列消费者收到延时消息");
        log.info("msg={}", message);
        log.info("deliveryTag={}", deliveryTag);
        channel.basicAck(deliveryTag, false);
    }

}
