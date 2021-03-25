package cn.bravedawn.producer;

import cn.bravedawn.kafka.Application;
import cn.bravedawn.kafka.producer.KafkaProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : depers
 * @program : mall-kafka
 * @description: 测试案例
 * @date : Created in 2021/3/23 21:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class KafkaProducerTest {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Test
    public void test() throws InterruptedException {
        String topic = "test";
        for (int i = 0; i < 1000; i++) {
            kafkaProducerService.sendMessage(topic, "hello topic" + i);
            Thread.sleep(500);
        }

        Thread.sleep(Integer.MAX_VALUE);
    }

}
