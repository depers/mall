package cn.bravedawn.collection.map.hashmap.internals;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/30 7:28
 */
public class CollectionViewsExample3 {

    /**
     * set view of entry in the map
     * HashMap中提供的第三个视图集合：map中所有条目的视图
     */


    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "baeldung");
        map.put("type", "blog");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key = " + key + " ,value = " + value);
        }
    }
}
