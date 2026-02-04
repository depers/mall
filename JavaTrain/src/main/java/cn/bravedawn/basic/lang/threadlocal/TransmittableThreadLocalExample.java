package cn.bravedawn.basic.lang.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author : depers
 * @Date : Created in 2026-01-28 19:30
 */
public class TransmittableThreadLocalExample {

    /**
     * TransmittableThreadLocal可以实现父线程向子线程传递值，也能够实现子线程修改值
     */

    public static void main(String[] args) throws InterruptedException {
        TransmittableThreadLocal<String> local = new TransmittableThreadLocal<>();
        local.set("我是主线程");
        //生成额外的代理
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        //**核心装饰代码！！！！！！！！！**
        executorService = TtlExecutors.getTtlExecutorService(executorService);
        CountDownLatch c1 = new CountDownLatch(1);
        CountDownLatch c2 = new CountDownLatch(1);
        executorService.submit(() -> {
            System.out.println("我是线程1：" + local.get());
            c1.countDown();
        });
        c1.await();
        local.set("修改主线程");
        System.out.println(local.get());
        executorService.submit(() -> {
            System.out.println("我是线程2：" + local.get());
            c2.countDown();
        });
        c2.await();
    }
}
