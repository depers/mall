package cn.bravedawn.jvm.gc;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/4/13 19:56
 */
public class DynamicAgeJudgeDemo {

    /**
     * 动态对象年龄判定
     * VM参数：-Xms20M -Xmx20M -Xmn10M -Xlog:gc* -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:MaxTenuringThreshold=15
     */


    private static final int _1M = 1024 * 1024;


    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[_1M / 4];
        allocation2 = new byte[_1M / 4];

        allocation3 = new byte[4 * _1M];
        allocation4 = new byte[4 * _1M];

        allocation4 = null;
        allocation4 = new byte[4 * _1M];
    }


    public static void main(String[] args) {
        testTenuringThreshold();
    }
}
