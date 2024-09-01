package cn.bravedawn.autoprefetch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : rabbitmq-spring-boot-prefetch
 * @date : Created in 2024/9/1 09:58
 */

@Component
@Slf4j
public class RabbitConsumer {


    @RabbitListener(queues = RabbitMQConfig.QUEUE, containerFactory = "simpleFactory")
    public void receive(String message) throws InterruptedException {
        log.info("RabbitConsumer received message: {}", message);
        Thread.sleep(200);
    }
}
