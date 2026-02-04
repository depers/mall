package cn.bravedawn.basic.lang.threadlocal;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author : depers
 * @Date : Created in 2026-01-28 10:51
 */
public class InheritableThreadLocalExample {

    /**
     * InheritableThreadLocal可以实现父线程向子线程传递变量，但是子线程无法修改变量的值
     * 子线程可以读取父线程的值，但是无法修改值
     */

    public static void main(String[] args) {
        ThreadLocal<String> local = new InheritableThreadLocal<>();
        try {
            local.set("我是主线程");
            ExecutorService executorService = Executors.newFixedThreadPool(1);
            CountDownLatch c1 = new CountDownLatch(1);
            CountDownLatch c2 = new CountDownLatch(1);
            //初始化init的时候，赋予了父线程的ThreadLocal的值
            executorService.execute(() -> {
                System.out.println("线程1" + local.get());
                c1.countDown();
            });
            c1.await();
            //主线程修改值
            local.set("修改主线程");
            //再次调用，查看效果
            executorService.execute(() -> {
                System.out.println("线程2" + local.get());
                c2.countDown();
            });
            c2.await();
            executorService.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //使用完毕，清除线程中ThreadLocalMap中的key。
            local.remove();
        }
    }
}
