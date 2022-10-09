package cn.bravedawn.collection.map.treemap;

import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/8 11:21
 */
public class TreeMapExample3 {

    /**
     * 自定义TreeMap的排序规则
     * 下面演示的是按照整数的倒序进行排序
     */

    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());

        map.put(3, "val");
        map.put(2, "val");
        map.put(1, "val");
        map.put(5, "val");
        map.put(4, "val");

        System.out.println(map); // {5=val, 4=val, 3=val, 2=val, 1=val}
    }
}
