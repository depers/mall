package cn.bravedawn.jvm.memory;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/31 21:51
 */
public class HeapSizeTest {

    /**
     * JVM的内存容量
     */

    public static void main(String[] args) {
        // 获取Java 虚拟机中的内存总容量
        System.out.println("totalMemory = " + Runtime.getRuntime().totalMemory()/1024/1024 + "m");
        // 获取Java 虚拟机中的可用内存量
        System.out.println("freeMemory = " + Runtime.getRuntime().freeMemory()/1024/1024 + "m");
        // 获取Java 虚拟机将尝试使用的最大内存量
        System.out.println("maxMemory = " + Runtime.getRuntime().maxMemory()/1024/1024 + "m");
    }
}
