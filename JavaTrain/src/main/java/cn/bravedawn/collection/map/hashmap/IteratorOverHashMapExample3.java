package cn.bravedawn.collection.map.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/28 21:06
 */
public class IteratorOverHashMapExample3 {

    /**
     *  Map的遍历方法三：遍历map的所value值
     * 注意：map的遍历是随机没有顺序的
     */


    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 123);
        map.put("pear", 456);
        map.put("banana", 789);

        for (Integer val : map.values()) {
            System.out.println(val);
        }

        /**
         * 789
         * 123
         * 456
         */
    }
}
