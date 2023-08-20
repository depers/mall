package cn.bravedawn.collection.map.hashmap.java8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/28 21:22
 */
public class ForEachExample2 {

    /**
     * 使用Java8之前的方法遍历map
     */

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 123);
        map.put("pear", 456);
        map.put("banana", 789);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("key: " + key + ", value: " + value);
        }


        /**
         * 输出：
         * key: banana, value: 789
         * key: apple, value: 123
         * key: pear, value: 456
         */
    }
}
