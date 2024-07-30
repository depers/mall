package cn.bravedawn.consumer;

import cn.bravedawn.mq.RabbitmqConfig;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * @author : depers
 * @program : rabbitmq-spring-boot-thread-model-recover
 * @date : Created in 2024/7/4 15:56
 */

@Component
@Slf4j
public class MessageConsumer {


    @RabbitListener(queues = RabbitmqConfig.QUEUE, containerFactory = "simpleContainerFactory")
    public void receive(String message) {
        log.info("收到simple队列中的消息：{}", message);
        int i = 1 / 0;
    }


    @RabbitListener(queues = RabbitmqConfig.UNIFY_QUEUE)
    public void unifyReceive(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
        log.info("收到统一配置的消息：" + message);


        channel.basicAck(deliveryTag, false);
    }
}
