package cn.bravedawn.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/5/12 20:36
 */
public class MapExample {

    /**
     * Map的遍历：通过循环遍历Map实例的keySet()方法返回的Set集合
     */


    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 123);
        map.put("pear", 456);
        map.put("banana", 789);

        for (String key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println(key + " = " + value);
        }

    }
}
