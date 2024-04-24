package cn.bravedawn.collection.map.hashmap.java8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/28 21:25
 */
public class GetOrDefaultExample {

    /**
     * 从map中检索相应key的value，如果检索不到返回默认值
     */


    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 123);
        map.put("pear", 456);
        map.put("banana", 789);

        Integer defaultValue = map.getOrDefault("orange", 666);
        System.out.println(defaultValue); // 666
    }
}
