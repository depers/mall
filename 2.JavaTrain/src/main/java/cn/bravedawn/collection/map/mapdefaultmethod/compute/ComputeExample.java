package cn.bravedawn.collection.map.mapdefaultmethod.compute;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/13 14:02
 */
public class ComputeExample {

    /**
     * compute()方法：
     *  1.若key对应的键值对是存在的，若value的计算为null，移除该key对应的键值对；
     *  2.若key对应的键值对不存在，若value的计算为null，原有的map保持不变，该key也不会被添加到map中；
     */

    public static void main(String[] args) {
        test_compute_key_is_exist();
    }

    static void test_compute_key_is_exist() {
        Map<String, Object> concurrentMap = new ConcurrentHashMap<>();
        Object oldValue = new Object();
        concurrentMap.put("test", oldValue);
        concurrentMap.compute("test", (k, v) -> null);

        System.out.println(concurrentMap.get("test"));
        System.out.println(concurrentMap.size());
    }

    static void test_compute_key_is_not_exit() {
        Map<String, Object> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("test1", 1);
        concurrentMap.compute("test2", (k, v) -> null);
        System.out.println(concurrentMap); // {test1=1}
    }
}
