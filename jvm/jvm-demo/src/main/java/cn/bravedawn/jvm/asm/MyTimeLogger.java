package cn.bravedawn.jvm.asm;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/7 16:59
 */
public class MyTimeLogger {

    private static long start = 0;

    public static void start() {
        start = System.currentTimeMillis();
    }

    public static void end() {
        long end = System.currentTimeMillis();
        System.out.println("method test consume time is " + (end - start));    }
}
