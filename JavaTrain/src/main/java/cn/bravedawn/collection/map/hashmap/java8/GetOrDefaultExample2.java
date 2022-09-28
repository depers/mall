package cn.bravedawn.collection.map.hashmap.java8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/28 21:29
 */
public class GetOrDefaultExample2 {

    /**
     * 采用Java8之前的办法提供默认值
     */

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 123);
        map.put("pear", 456);
        map.put("banana", 789);

        Integer defaultValue = map.containsKey("orange")
                ? map.get("orange")
                : 666;

        System.out.println(defaultValue); // 666
    }
}
