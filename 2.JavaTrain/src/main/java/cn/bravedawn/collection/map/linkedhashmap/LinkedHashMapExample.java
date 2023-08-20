package cn.bravedawn.collection.map.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/6 15:55
 */
public class LinkedHashMapExample {

    /**
     * LinkedHashMap默认的迭代顺序是 插入顺序
     */

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1, null);
        map.put(2, null);
        map.put(3, null);
        map.put(4, null);
        map.put(5, null);

        Set<Integer> keys = map.keySet();
        Integer[] arr = keys.toArray(new Integer[0]);

        for (Integer item : arr) {
            System.out.println(item);
        }
    }
}
