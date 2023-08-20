package cn.bravedawn.java8.method;

public class MethodInvokeExample {

    /**
     * Runnable.run()方法时顺序执行的，不会新启线程去做
     */

    static {
        tryInvoke(MethodInvokeExample::print);
    }



    public static void print() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("test");
    }


    public static void tryInvoke(Runnable runnable) {
        System.out.println(Thread.currentThread().getName());
        runnable.run();
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MethodInvokeExample example = new MethodInvokeExample();
    }


}
