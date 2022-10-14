package cn.bravedawn.collection.map.concurrenthashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/13 11:51
 */
public class ConcurrentHashMapExample3 {

    /**
     * ConcurrentHashMap中key和value是不允许存在null值的
     */

    public static void main(String[] args) {
        test_null_value();
    }

    static void test_null_key() {
        Map<String, Object> map = new ConcurrentHashMap();
        map.put(null, new Object()); // concurrentMap.put(null, new Object());
    }

    static void test_null_value() {
        Map<String, Object> map = new ConcurrentHashMap();
        map.put("test", null); // concurrentMap.put(null, new Object());
    }



}
