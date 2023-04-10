package cn.bravedawn.jvm.gc;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/4/8 22:26
 */
public class MaxTenuringGCDemo {

    /**
     * 长期存活的对象将进入老年代
     * VM参数：-Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:MaxTenuringThreshold=1
     */

    private static final int _1M = 1024 * 1024;

    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1M / 4];
        // 什么时候进入老年代取决于XX:MaxTenuringThreshold设置
        allocation2 = new byte[4 * _1M];
        allocation3 = new byte[4 * _1M];
        allocation3 = null;
        allocation3 = new byte[4 * _1M];
    }

    public static void main(String[] args) {
        testTenuringThreshold();
    }
}
