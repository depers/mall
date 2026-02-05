package cn.bravedawn.basic.lang.threadlocal;

/**
 * @Author : depers
 * @Date : Created in 2026-02-05 11:04
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalLeakDemo {


    /**
     * -Xmx64m
     * -XX:+HeapDumpOnOutOfMemoryError
     */

    // 注意：这里是 static ThreadLocal
    private static final ThreadLocal<byte[]> THREAD_LOCAL = new ThreadLocal<>();

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {

            executor.execute(() -> {
                // 每次往 ThreadLocal 放 5MB 数据
                THREAD_LOCAL.set(new byte[5 * 1024 * 1024]);

                // ❌ 没有 remove
                // THREAD_LOCAL.remove();
            });

            Thread.sleep(10);
        }

        System.out.println("任务提交完成");
    }
}
