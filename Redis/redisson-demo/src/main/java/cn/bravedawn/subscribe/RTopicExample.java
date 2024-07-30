package cn.bravedawn.subscribe;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.api.listener.MessageListener;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;

/**
 * @author : depers
 * @program : redisson-demo
 * @date : Created in 2024/7/15 22:06
 */


@Slf4j
public class RTopicExample {
    private static RedissonClient redissonClient;

    static {
        Config config = new Config();
        config.setCodec(new JsonJacksonCodec());
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        redissonClient = Redisson.create(config);
    }

    public static void main(String[] args) throws InterruptedException {
        RTopic topic = redissonClient.getTopic("test");
        topic.addListener(String.class, new MessageListener<String>() {
            @Override
            public void onMessage(CharSequence channel, String msg) {
                log.info("收到了订阅的消息, {}", msg);
            }
        });


        log.info("发送订阅消息");
        Thread.sleep(2000);
        topic.publish("hello world");


    }
}
