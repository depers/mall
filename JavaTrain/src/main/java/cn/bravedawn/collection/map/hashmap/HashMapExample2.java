package cn.bravedawn.collection.map.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample2 {

    /**
     * map中对key做比较也是通过equals实现的，这一点和list是一样的
     * 要正确的使用map，作为key值的对象必须正确覆写equals方法
     */


    public static void main(String[] args) {
        String key1 = "a";
        Map<String, Integer> map = new HashMap<>();
        map.put(key1, 123);

        String key2 = new String("a");
        map.get(key2); // 123

        System.out.println(key1 == key2); // false
        System.out.println(key1.equals(key2)); // true
    }
}
