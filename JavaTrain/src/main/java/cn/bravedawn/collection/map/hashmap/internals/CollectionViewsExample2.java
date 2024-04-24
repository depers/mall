package cn.bravedawn.collection.map.hashmap.internals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/30 7:24
 */
public class CollectionViewsExample2 {

    /**
     * Collection view of the value
     * HashMap中提供的第二个视图集合是关于 值 的视图
     */

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "baeldung");
        map.put("type", "blog");

        Collection<String> values = map.values();
        System.out.println(values); // [baeldung, blog]

        // 移除值视图中的元素，会同步体现在map中
        values.remove("blog");
        System.out.println(values); // [baeldung]
        System.out.println(map); // {name=baeldung}

    }
}
