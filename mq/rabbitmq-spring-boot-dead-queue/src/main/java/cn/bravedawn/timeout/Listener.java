package cn.bravedawn.timeout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : rabbitmq-spring-boot-dead-queue
 * @date : Created in 2024/8/5 13:47
 */

@Component
@Slf4j
public class Listener {

    /**
     * 为了方便演示，针对队列a和队列b不设置消费者，只这是死信队列的消费者
     */

    @RabbitListener(queues = Config.deadQueue)
    public void onMessage(@Payload String message) {
        log.info("收到死信队列的消息：{}", message);
    }
}
