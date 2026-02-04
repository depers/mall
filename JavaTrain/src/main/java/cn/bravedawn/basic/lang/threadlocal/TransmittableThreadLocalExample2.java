package cn.bravedawn.basic.lang.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @Author : depers
 * @Date : Created in 2026-02-02 14:35
 */
public class TransmittableThreadLocalExample2 {


    public static void main(String[] args) throws InterruptedException {
        TransmittableThreadLocal<String> transmittableThreadLocal = new TransmittableThreadLocal<>();
        transmittableThreadLocal.set("hello 1");

        new Thread(() -> {
            // 获取值
            String value = transmittableThreadLocal.get();
            System.out.println("获取到的值：" + value);

            // 修改值
            transmittableThreadLocal.set("hello 2");
        }).start();

        Thread.sleep(1000);
        System.out.println("当前获取到的值：" + transmittableThreadLocal.get());
    }
}
