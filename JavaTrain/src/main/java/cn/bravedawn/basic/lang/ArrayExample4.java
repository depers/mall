package cn.bravedawn.basic.lang;

import java.util.Arrays;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/13 11:34
 */
public class ArrayExample4 {

    /**
     * 二位数组的长度是行数
     */

    public static void main(String[] args) {
        int[][] ns = {
                {1, 2, 3, 4},
                {5, 6},
                {7, 8, 9}
        };

        System.out.println(ns.length);
        System.out.println(ns[0].length);
    }
}
