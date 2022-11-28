package cn.bravedawn.collection.list.copylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/19 13:26
 */
public class CopyListExample5 {

    /**
     * 拷贝列表中的元素到另一个列表：第五种方法是使用Java10提供的List.copyOf()方法
     */


    public static void main(String[] args) {
        // Java10提供的List.copyOf()方法会返回一个不可变的列表
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> copy = List.copyOf(list);
        System.out.println(copy);

        // 不允许集合中包含null元素
        List<Integer> list2 = Arrays.asList(1, 2, 3, null);
        List<Integer> copy2 = List.copyOf(list2); // java.lang.NullPointerException
        System.out.println(copy);

        // 不允许给定的集合为null
        List<Integer> copy3 = List.copyOf(null); // java.lang.NullPointerException
        System.out.println(copy);

    }
}
