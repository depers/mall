package cn.bravedawn;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : rabbitmq-spring-boot-retry-demo
 * @date : Created in 2024/6/18 14:33
 */
@Component
@Slf4j
public class RabbitReceiver {


    //测试重试
    // @RabbitListener(queues = "${mq.queueBinding.queue}")
    // public void infoConsumption(String data, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag, Message message) throws Exception {
    //     int retryCount = message.getMessageProperties().getHeader("x-retries-count");
    //     int count  = 1;
    //     log.info("重试次数 = {}, retryCount={}", count++, retryCount);
    //
    // }

    // //测试重试
    // @RabbitListener(queues = "errorQueue")
    // public void errorConsumer(String data, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
    //     log.info("接收到死信消息， data = {}", data);
    // }
}

