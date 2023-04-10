package cn.bravedawn.jvm.gc;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/4/8 22:12
 */
public class BigObjectGCDemo {

    /**
     * 大对象直接分配到老年代
     * -XX:PretenureSizeThreshold=3145728：意思是说超过3M的对象会直接被分配到老年代
     * VM参数：-Xms20M -Xmx20M -Xmn10M -Xlog:gc* -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:PretenureSizeThreshold=3145728
     */

    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }


    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1M];
    }
}
