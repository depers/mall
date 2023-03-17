package cn.bravedawn.jvm.gc;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/3/17 21:15
 */
public class MinorGCDemo {

    /**
     * VM参数：-Xms20M -Xmx20M -Xmn10M -Xlog:gc* -XX:SurvivorRatio=8 -XX:+UseSerialGC
     */

    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
        testAllocation();
    }


    private static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1M];
        allocation2 = new byte[2 * _1M];
        allocation3 = new byte[2 * _1M];
        allocation4 = new byte[4 * _1M];
    }
}
