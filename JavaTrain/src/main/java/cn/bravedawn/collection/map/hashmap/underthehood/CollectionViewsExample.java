package cn.bravedawn.collection.map.hashmap.underthehood;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/30 7:20
 */
public class CollectionViewsExample {

    /**
     * Collection view of the key
     * HashMap中提供的第一个视图集合是关于 键 的视图
     */

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "baeldung");
        map.put("type", "blog");

        Set<String> keys = map.keySet();
        System.out.println(keys); // [name, type]

        // 移除键视图中的元素，会同步体现在map中
        keys.remove("name");
        System.out.println(keys); // [type]
        System.out.println(map); // {type=blog}
    }
}
