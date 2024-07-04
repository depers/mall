package cn.bravedawn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : rabbitmq-spring-boot-retry-demo
 * @date : Created in 2024/6/18 14:32
 */
@Component
@Slf4j
public class RabbitSender {

    @Value("${mq.queueBinding.exchange.name}")
    private String exchangeName;

    @Value("${mq.queueBinding.key}")
    private String key;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String msg) {
        log.info("RabbitSender.send() msg = {}", msg);
        // 将消息发送给业务交换机
        rabbitTemplate.convertAndSend(exchangeName, key, msg);

    }

}
