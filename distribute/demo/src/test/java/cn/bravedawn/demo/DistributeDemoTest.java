package cn.bravedawn.demo;

import cn.bravedawn.demo.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    public void concurrentOrder() throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(5);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            es.execute(() -> {
                try {
                    // 让五个线程同步开始执行创建订单的操作
                    cyclicBarrier.await();
                    Integer orderId = orderService.createOrderV1();
                    System.out.println("订单id: " + orderId);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // 每执行完一个线程减1
                    cdl.countDown();
                }
            });
        }
        // 等待5个线程都执行完毕后，再关闭线程池杀掉主进程。如果不用CountDownLatch让线程进行等待的话，
        // 主线程提前结束会导致数据库连接关闭，新开的五个线程就获取不到数据库连接了，效果就是什么都没做
        cdl.await();
        es.shutdown();
    }
}
