package cn.bravedawn.collection.map.hashmap.java8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/28 21:17
 */
public class ForEachExample {

    /**
     * 使用Java8 的 forEach()函数遍历map
     */

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 123);
        map.put("pear", 456);
        map.put("banana", 789);

        map.forEach((key, value) -> {
            System.out.println("key: " + key + ", value: " + value);
        });

        /**
         * 输出：
         * key: banana, value: 789
         * key: apple, value: 123
         * key: pear, value: 456
         */
    }
}
