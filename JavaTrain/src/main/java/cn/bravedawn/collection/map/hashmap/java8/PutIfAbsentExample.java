package cn.bravedawn.collection.map.hashmap.java8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/29 7:34
 */
public class PutIfAbsentExample {

    /**
     * Java8：putIfAbsent方法
     * 1.若指定的key没有与value相关联或是与null关联，该方法会返回null
     * 2.否则，就会返回这个key已经绑定的值。而且你不会修改这个已经绑定的值
     */

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 123);
        map.put("pear", 456);
        map.put("banana", 789);
        map.put("orange", null);

        Integer grape = map.putIfAbsent("grape", 345);
        Integer orange = map.putIfAbsent("orange", 567);
        Integer apple = map.putIfAbsent("apple", 111);

        System.out.println(grape);  // null
        System.out.println(orange); // null
        System.out.println(apple);  // 123
        System.out.println(map.get("grape")); // 345
        System.out.println(map.get("orange")); // 567
        System.out.println(map.get("apple"));  // 123


    }
}
