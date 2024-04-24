package cn.bravedawn.jvm.memory;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/3/3 21:55
 */
public class StackOverflowErrorExample2 {


    /**
     * 虚拟机参数：-Xss2m
     * 多线程执行方法
     */


    private static void dontStop() {
        while (true) {

        }
    }


    public static void main(String[] args) {
        while(true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }
}
