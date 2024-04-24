package cn.bravedawn.jvm.gc;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/4/13 21:07
 */
public class AllocationGuarantee {

    /**
     * 空间分配担保
     * vm参数：-Xms20M -Xmx20M -Xmn10M -Xlog:gc* -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:HandlePromotionFailure=false
     */


    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;

        allocation1 = new byte[2 * _1M];
        allocation2 = new byte[2 * _1M];
        allocation3 = new byte[2 * _1M];

        allocation1 = null;

        allocation4 = new byte[2 * _1M];
        allocation5 = new byte[2 * _1M];
        allocation6 = new byte[2 * _1M];

        allocation4 = null;
        allocation5 = null;
        allocation6 = null;

        allocation7 = new byte[2 * _1M];
    }

}
