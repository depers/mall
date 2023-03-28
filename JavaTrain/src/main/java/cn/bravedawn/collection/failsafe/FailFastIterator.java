package cn.bravedawn.collection.failsafe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/3/28 20:04
 */
public class FailFastIterator {

    /**
     * 当我们使用 Fail-fast 迭代器时，如果在线程迭代集合时从集合中添加或删除元素，
     * 它会立即抛出 ConcurrentModificationException。
     *
     * 示例：HashMap 中的迭代器
     */

    public static void main(String[] args) {
        // create map
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "emma");
        map.put(2, "paul");
        map.put(3, "walker");

        // create an instance of the Iterator class
        Iterator iterator = map.keySet().iterator();

        // iterating map using Iterator
        while (iterator.hasNext()) {
            System.out.println(map.get(iterator.next()));

            // 这里将会抛出java.util.ConcurrentModificationException
            map.put(104, "rubby");

        }
    }
}
