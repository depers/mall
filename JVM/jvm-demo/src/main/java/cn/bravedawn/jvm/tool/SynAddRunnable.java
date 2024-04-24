package cn.bravedawn.jvm.tool;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/4/21 20:26
 */
public class SynAddRunnable implements Runnable{


    /**
     * 线程死锁等待的演示
     */

    int a, b;

    SynAddRunnable(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        /**
         * 因为Integer.valueOf()方法出于减少对象创建次数和节省内存的考虑，对数值在-128~127的Integer对象进行了缓存，如果valueOf()方法的参数在这个范围内，就会直接返回缓存中的对象
         * 放到这个案例中来看的话，也就是说在200个线程中，我们只有两个Integer对象，分别是Integer(1)和Integer(2)
         *
         * 下面的这段代码中，如果A线程在两个synchronized之间发生了一次线程切换，也就是CPU时间片发生了调度，另一个B线程开始执行
         * 这里假设A线程的a=1，b=2; B线程的a=2,b=1
         * 此时A线程占有了Integer(1)，B线程会顺序执行占有Integer(2)，这样的话A线程在等待B线程持有的Integer(2)，B线程在等待A线程持有的Integer(1)进而出现了死锁
         *
         * 这里我们可以使用JConsole线程页面的【检测死锁】来判断是否发生了死锁
         */
        synchronized (Integer.valueOf(a)) {
            synchronized (Integer.valueOf(b)) {
                System.out.println(a + b);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new SynAddRunnable(1, 2)).start();
            new Thread(new SynAddRunnable(2, 1)).start();
        }
    }
}
