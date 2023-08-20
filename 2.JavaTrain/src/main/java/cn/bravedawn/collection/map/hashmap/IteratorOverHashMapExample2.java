package cn.bravedawn.collection.map.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/5/12 20:40
 */
public class IteratorOverHashMapExample2 {

    /**
     * Map的遍历方法二：遍历map的所有元素
     * 通过循环遍历Map实例的entrySet()方法返回的Set集合
     * 注意：map的遍历是随机没有顺序的
     */


    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 123);
        map.put("pear", 456);
        map.put("banana", 789);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " = " + value);
        }

        /**
         * banana = 789
         * apple = 123
         * pear = 456
         */
    }
}
