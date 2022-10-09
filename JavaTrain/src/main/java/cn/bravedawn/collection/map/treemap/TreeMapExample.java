package cn.bravedawn.collection.map.treemap;

import java.util.TreeMap;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/8 11:07
 */
public class TreeMapExample {

    /**
     * 当TreeMap的键为整数时，默认顺序是按照整数键的升序顺序进行排序的
     */


    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(3, "val");
        map.put(2, "val");
        map.put(1, "val");
        map.put(5, "val");
        map.put(4, "val");

        System.out.println(map); // {1=val, 2=val, 3=val, 4=val, 5=val}
    }
}
