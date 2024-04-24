package cn.bravedawn.basic.lang.array.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : depers
 * @program : 2.JavaTrain
 * @date : Created in 2024/1/22 22:25
 */
public class ArraysExample {

    /**
     * 对数组进行排序
     */

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 6, 4, 8};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
