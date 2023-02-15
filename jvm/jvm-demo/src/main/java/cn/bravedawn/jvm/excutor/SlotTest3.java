package cn.bravedawn.jvm.excutor;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/2/14 21:49
 */
public class SlotTest3 {

    /**
     * "slot是复用的，以节省栈帧的空间，这种设计可能会影响到系统的垃圾收集行为"的演示
     *
     * JVM参数配置：-XX:+UseConcMarkSweepGC -Xmx10m -Xms5m -Xlog:gc*
     */

    public static void main(String[] args) {
        {
            byte[] bs = new byte[2*1024*1024];
            bs = null; // 情况三
        }

        // int i = 5; // 情况一
        // int a = 5; // 情况二

        System.gc();

        /** 第一种情况：不声明int i = 5, GC之后堆中的空间没有被释放
         * 这里的局部变量表中slot的布局
         * 0--args
         * 1--bs 指向堆空间中2M的数据
         */

        /** 第二种情况：声明int a = 5, GC之后堆中的空间会被释放，slot-1会被复用
         * 这里的局部变量表中slot的布局
         * 0--args
         * 1--a
         */

        /**
         * 第三种情况：在bs所在的作用域手动将其赋值为null，指向堆的指针就没了，GC之后堆中的空间会被释放，slot-1的位置就空了
         * 0--args
         * 1
         */


        // 获取Java 虚拟机中的内存总容量
        System.out.println("totalMemory = " + Runtime.getRuntime().totalMemory()/1024.0/1024.0 + "m");
        // 获取Java 虚拟机中的可用内存量
        System.out.println("freeMemory = " + Runtime.getRuntime().freeMemory()/1024.0/1024.0 + "m");
        // 获取Java 虚拟机将尝试使用的最大内存量
        System.out.println("maxMemory = " + Runtime.getRuntime().maxMemory()/1024.0/1024.0 + "m");
    }
}
