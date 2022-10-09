package cn.bravedawn.collection.map.treemap;

import java.util.Set;
import java.util.TreeMap;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/8 11:28
 */
public class TreeMapExample4 {

    /**
     * 因为TreeMap 树映射的属性，可以方便的获取 “最大的键”，“最小的键”，“大于或小于某个值的键”
     */

    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(3, "val");
        map.put(2, "val");
        map.put(1, "val");
        map.put(5, "val");
        map.put(4, "val");

        Integer highestKey = map.lastKey();
        Integer lowestKey = map.firstKey();

        Set<Integer> keysLessThan3 = map.headMap(3).keySet();
        Set<Integer> keysGreaterThanEqTo3 = map.tailMap(3).keySet();

        System.out.println(map); // {1=val, 2=val, 3=val, 4=val, 5=val}
        System.out.println(highestKey); // 5
        System.out.println(lowestKey); // 1
        System.out.println(keysLessThan3); // [1, 2]
        System.out.println(keysGreaterThanEqTo3); // [3, 4, 5]
    }
}
