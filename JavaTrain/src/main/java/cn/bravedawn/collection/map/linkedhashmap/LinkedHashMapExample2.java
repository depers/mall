package cn.bravedawn.collection.map.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/6 16:00
 */
public class LinkedHashMapExample2 {

    /**
     * 若我们在LinkedHashMap的初始化方法中，设置accessOrder的值为 true，则元素的迭代顺序就会被设置为最近最少使用（这里的使用，包括put和get），即 LRU。
     * 也就是说在元素的迭代顺序中，最近最少被使用的元素会排在前面，最近最多被使用的元素会排在后面。
     */

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(16, .75f, true);
        map.put(1, null);
        map.put(2, null);
        map.put(3, null);
        map.put(4, null);
        map.put(5, null);

        Set<Integer> keys = map.keySet();
        System.out.println(keys); // [1, 2, 3, 4, 5]

        map.get(4);
        System.out.println(keys); // [1, 2, 3, 5, 4]

        map.get(1);
        System.out.println(keys); // [2, 3, 5, 4, 1]

        map.get(3);
        System.out.println(keys); // [2, 5, 4, 1, 3]

    }
}
