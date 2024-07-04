package cn.bravedawn.consumer;

import cn.bravedawn.mq.RabbitmqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * @author : depers
 * @program : rabbitmq-spring-boot-thread-model-recover
 * @date : Created in 2024/7/4 15:56
 */

@Component
@Slf4j
public class MessageConsumer {


    @RabbitListener(queues = RabbitmqConfig.QUEUE)
    public void receive(String message) {
        log.info(message);
        int i = 1 / 0;
    }


    @RabbitListener(queues = RabbitmqConfig.ERROR_QUEUE)
    public void error(String message) {
        log.info("收到异常消息：" + message);
    }
}
