package cn.bravedawn.demo;

import cn.bravedawn.demo.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : depers
 * @program : demo
 * @description: DistributeDemo测试
 * @date : Created in 2021/5/7 23:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DistributeDemoTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void concurrentOrder() {

    }
}
