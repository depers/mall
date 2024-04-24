package cn.bravedawn.collection.list.iteratoroverlist;

import java.util.Arrays;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/22 17:34
 */
public class IteratorOverListExample {

    /**
     * 遍历一个列表
     * 方法一：使用for循环
     */

    public static void main(String[] args) {
        List<String> countries = Arrays.asList("Germany", "Panama", "Australia");
        for (int i = 0; i < countries.size(); i++) {
            System.out.println(countries.get(i));
        }
    }
}
