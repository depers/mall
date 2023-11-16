package cn.bravedawn.collection.map.hashmap.threadunsafe;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-11-07 09:12
 */
public class ThreadUnSafeExample {

    /**
     * HashMap线程不安全的原因
     * 最大的容量是2的30次，也就是1073741824
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        addElement();

    }


    static void addElement() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "1");
        map.put("3", "1");

    }
}
