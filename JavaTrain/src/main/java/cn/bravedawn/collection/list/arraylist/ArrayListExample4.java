package cn.bravedawn.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/6/4 18:48
 *
 * 初始化数组时，是否会对其中的元素进行初始化
 */
public class ArrayListExample4 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(2);
        int[] array = new int[2];
        Integer[] array1 = new Integer[2];

        System.out.println(list); //[]
        System.out.println(Arrays.toString(array)); // [0, 0]
        System.out.println(Arrays.toString(array1)); // [null, null]
    }
}
