package cn.bravedawn.basic.lang;

import java.util.Arrays;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/13 11:34
 */
public class ArrayExample3 {

    /**
     * 二位数组中，每一行的数组的长度并不要求相同
     */

    public static void main(String[] args) {
        int[][] ns = {
                {1, 2, 3, 4},
                {5, 6},
                {7, 8, 9}
        };

        System.out.println(Arrays.deepToString(ns));
    }
}
