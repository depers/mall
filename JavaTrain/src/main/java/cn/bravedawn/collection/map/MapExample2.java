package cn.bravedawn.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/5/12 20:40
 */
public class MapExample2 {

    /**
     * Map的遍历：通过循环遍历Map实例的entrySet()方法返回的Set集合
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
    }
}
