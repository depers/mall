package cn.bravedawn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author : depers
 * @program : rabbitmq-spring-boot-retry-demo
 * @date : Created in 2024/8/16 10:36
 */
@Slf4j
public class CallBackExhaustedRecover implements MessageRecoverer {

    private BiConsumer<String, Throwable> consumer;


    public CallBackExhaustedRecover(BiConsumer<String, Throwable> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void recover(Message message, Throwable cause) {
        log.info("消息已达重试上限, message={}, cause={}", message, cause);

        // 定义前置处理，比如更新业务逻辑字段
        consumer.accept(new String(message.getBody()), cause);

        // 做一些固定的逻辑，如比将失败的消息入库
    }
}
