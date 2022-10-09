package cn.bravedawn.collection.map.treemap;

import java.util.TreeMap;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/8 11:11
 */
public class TreeMapExample2 {

    /**
     * 当TreeMap的键为字符串时，默认顺序是按照字符串键的首字母的字母顺序进行排序的
     */

    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("cKey", "val");
        map.put("caKey", "val");
        map.put("aKey", "val");
        map.put("bKey", "val");

        System.out.println(map); // {aKey=val, bKey=val, cKey=val, caKey=val}
    }
}
