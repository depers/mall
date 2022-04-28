package cn.bravedawn.collection.list;

import java.util.Arrays;
import java.util.List;

/**
 * @author : fengx9
 * @program : JavaTrain
 * @date : Created in 2022/04/27 11:18 AM
 */
public class ListExample3 {

    /**
     * 将Array转为List
     */

    public static void main(String[] args) {
        func3();
    }


    // Java9 才支持的方法，of方法返回的是一个只读的list
    static void func1() {
        Integer[] array = { 1, 2, 3 };
        List<Integer> list = List.of(array);
        System.out.println(list);
    }


    static void func2() {
        Integer[] array = { 1, 2, 3 };
        List<Integer> list = Arrays.asList(array);
        System.out.println(list);
    }

    static void func3() {
        Integer[] array = { 1, 2, 3 };
        List<Integer> list = List.of(array);
        list.add(4); // UnsupportedOperationException
        System.out.println(list);
    }
}
