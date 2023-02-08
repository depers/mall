package cn.bravedawn.jvm.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/31 21:51
 */
public class HeapSizeTest {

    /**
     * 演示虚拟机堆大小相关配置的效果
     */

    private byte[] bs = new byte[1024 * 1025];

    public static void main(String[] args) {

        List<HeapSizeTest> list = new ArrayList<>();
        int num = 0;
        try {
            while (true) {
                list.add(new HeapSizeTest());
                num++;
            }
        } catch (Throwable e) {
            System.out.println("now error, num = " + num);
            e.printStackTrace();
        }


        // 获取Java 虚拟机中的内存总容量
        System.out.println("totalMemory = " + Runtime.getRuntime().totalMemory()/1024.0/1024.0 + "m");
        // 获取Java 虚拟机中的可用内存量
        System.out.println("freeMemory = " + Runtime.getRuntime().freeMemory()/1024.0/1024.0 + "m");
        // 获取Java 虚拟机将尝试使用的最大内存量
        System.out.println("maxMemory = " + Runtime.getRuntime().maxMemory()/1024.0/1024.0 + "m");
    }
}
