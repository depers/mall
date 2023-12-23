package cn.bravedawn.collection.map.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-12 15:50
 */
public class HashMapExample3 {

    /**
     * 尽管我将map设置为final，这只意味着map指向的对象引用不可修改，但是map中存储的值是不能修改的
     */

    private static final Map<String, String> map = new HashMap<>();

    static {
        map.put("1", "2");
    }


    public static void main(String[] args) {
        System.out.println(map);
    }
}
