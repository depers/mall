package cn.bravedawn.collection.collections;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-11-02 15:26
 */
public class CollectionsSingletonExample {

    /**
     * 创建单个元素的集合
     * 要注意返回的单元素集合也是不可变集合，无法向其中添加或删除元素
     */

    public static void main(String[] args) {
        List<String> list = Collections.singletonList("a");
        Map<String, String> map = Collections.singletonMap("a", "1");
        Set<String> set = Collections.singleton("a");
    }
}
