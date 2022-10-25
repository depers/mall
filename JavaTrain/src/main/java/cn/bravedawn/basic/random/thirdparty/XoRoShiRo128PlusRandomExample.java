package cn.bravedawn.basic.random.thirdparty;

import it.unimi.dsi.util.XoRoShiRo128PlusRandom;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/25 17:37
 */
public class XoRoShiRo128PlusRandomExample {

    /**
     * 这是最快的随机数生成器实现之一。它是由米兰大学信息科学系开发的
     *
     */

    public static void main(String[] args) {
        int min = 0;
        int max = 100;

        // 只有一种使用它的方法——通过nextInt方法。最重要的是，此方法仅适用于零参数和单参数调用。任何其他调用都将直接使用java.util.Random方法。
        XoRoShiRo128PlusRandom xoroRandom = new XoRoShiRo128PlusRandom();
        int randomWithXoRoShiRo128PlusRandom = xoroRandom.nextInt(max - min) + min;
        System.out.println(randomWithXoRoShiRo128PlusRandom);
    }
}
