package cn.bravedawn.basic.lang.threadlocal;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author : depers
 * @Date : Created in 2026-01-28 10:31
 */

@Slf4j
public class ThreadLocalExample {


    /**
     * 演示ThreadLocal向子线程中传递
     * 子线程无法读取父线程的值
     */

    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal<>();
        try {
            local.set("我是主线程");
            ExecutorService executorService = Executors.newFixedThreadPool(1);
            CountDownLatch c1 = new CountDownLatch(1);
            CountDownLatch c2 = new CountDownLatch(1);
            executorService.execute(() -> {
                System.out.println("线程1" + local.get());
                c1.countDown();
            });
            c1.await();
            executorService.execute(() -> {
                System.out.println("线程2" + local.get());
                c2.countDown();
            });
            c2.await();
            executorService.shutdownNow();
        } catch (InterruptedException e) {
            log.error("出现异常", e);
        } finally {
            //使用完毕，清除线程中ThreadLocalMap中的key。
            local.remove();
        }
    }
}
