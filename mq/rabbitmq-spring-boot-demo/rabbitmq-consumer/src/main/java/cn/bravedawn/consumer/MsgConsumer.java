package cn.bravedawn.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : rabbitmq-spring-boot-demo
 * @date : Created in 2024/6/24 22:39
 */

@Component
public class MsgConsumer {

    @RabbitListener(queues = "queue")
    public void receive(String msg){
        System.out.println(msg);
    }
}
