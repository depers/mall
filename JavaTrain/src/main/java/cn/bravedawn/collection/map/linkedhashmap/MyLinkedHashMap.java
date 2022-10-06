package cn.bravedawn.collection.map.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/6 16:11
 */
public class MyLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    /**
     * 重写LinkedHashMap的removeEldestEntry()方法，当键值对的大小超过maxEntries，就会从链表中移除那个
     * eldest条目（如果按照插入顺序来看的映射，eldest是映射中插入后时间最久的条目，或者如果这是按访问排序的映射，
     * 则为最近最少访问的条目。综上所示，最近最少使用的元素就是将被删除的条目）
     */

    private int maxEntries;

    public MyLinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder, int maxEntries) {
        super(initialCapacity, loadFactor, accessOrder);
        this.maxEntries = maxEntries;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > this.maxEntries;
    }

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map
                = new MyLinkedHashMap<>(16, .75f, true, 5);
        map.put(1, null);
        map.put(2, null);
        map.put(3, null);
        map.put(4, null);
        map.put(5, null);

        Set<Integer> keys = map.keySet();
        System.out.println(keys); // [1, 2, 3, 4, 5]

        map.put(6, null);
        System.out.println(keys); // [2, 3, 4, 5, 6]

        map.get(4);
        System.out.println(keys); // [2, 3, 5, 6, 4]
        map.put(7, null);
        System.out.println(keys); // [3, 5, 6, 4, 7]
    }
}
