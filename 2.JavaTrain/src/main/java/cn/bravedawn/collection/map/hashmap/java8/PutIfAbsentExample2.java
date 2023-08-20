package cn.bravedawn.collection.map.hashmap.java8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/29 7:44
 */
public class PutIfAbsentExample2 {

    /**
     * Java8之前我们通过如下方式模拟实现putIfAbsent()方法
     */

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 123);
        map.put("pear", 456);
        map.put("banana", 789);

        if (!map.containsKey("grape") || map.get("grape") == null) {
            Integer grape = map.put("grape", 345);
            System.out.println(grape);
        }
    }
}
