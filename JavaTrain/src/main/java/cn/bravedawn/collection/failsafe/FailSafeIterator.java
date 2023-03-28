package cn.bravedawn.collection.failsafe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/3/28 20:23
 */
public class FailSafeIterator {

    /**
     * 如果线程在迭代集合时从集合中不抛出ConcurrentModificationException异常，我们称为Non-Fail-fast或者是
     * Fail-safe。
     * Fail-safe迭代器会创建原始集合或对象数组的副本，并迭代该复制的集合。 在迭代器中所做的任何结构修改都会影响复制的集合，
     * 而不是原始集合。 因此，原始集合在结构上保持不变。
     *
     * 实例：ConcurrentHashMap
     */
    public static void main(String[] args) {
        // create map
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "emma");
        map.put(2, "paul");
        map.put(3, "walker");

        ConcurrentHashMap<Integer, String> copyMap = new ConcurrentHashMap<>(map);

        Iterator<Integer> itr = copyMap.keySet().iterator();

        while (itr.hasNext()) {
            System.out.println(copyMap.get(itr.next()));

            copyMap.put(104, "rubby");
        }
    }
}
