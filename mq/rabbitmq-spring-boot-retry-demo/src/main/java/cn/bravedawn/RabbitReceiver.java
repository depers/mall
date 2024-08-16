package cn.bravedawn;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : rabbitmq-spring-boot-retry-demo
 * @date : Created in 2024/6/18 14:33
 */
@Component
@Slf4j
public class RabbitReceiver {


    // 测试重试
    @RabbitListener(queues = "${mq.queueBinding.queue}", containerFactory = "rabbitListenerContainerFactory")
    public void infoConsumption(@Payload String msg, String data, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag, Message message) throws Exception {
        log.info("开始消费消息, msg={}", msg);
        int i  = 1 / 0;
    }

}

