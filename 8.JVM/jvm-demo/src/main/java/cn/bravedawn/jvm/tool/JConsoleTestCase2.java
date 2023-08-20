package cn.bravedawn.jvm.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/4/20 21:53
 */
public class JConsoleTestCase2 {

    /**
     * 这里主要演示了三个线程的动作
     * 第一个是main，main线程会等待System.in的输入，该线程处于Runnable状态，Runnable状态的线程操作系统还会为他分配CPU运行时间，但是这种等待只会消耗很小的处理器资源
     * 第二个是createBusyThread，由于死循环，该线程处于Runnable状态，这种情况会在空循环中耗尽操作系统分配给他的执行时间，指导线程切换为止，这种等待很消耗处理器资源
     * 第三个是createLockThread，该线程在等待lock对象的notify()和notifyAll()方法，该线程处理Waiting状态，早重新唤醒前不会分配执行时间
     *
     * 这个例子主要延时JConsole的 [线程] 页的功能，我们可以一次输入字符，运行程序，查看三个线程的状态
     */


    /**
     * 线程死循环演示
     */
    public static void createBusyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                    ;
            }
        }, "testBusyThread");

        thread.start();
    }


    /**
     * 线程等待演示
     * @param lock
     */
    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");

        thread.start();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 读取用户输入
        reader.readLine();
        createBusyThread();
        reader.readLine();
        Object obj = new Object();
        createLockThread(obj);
    }
}
