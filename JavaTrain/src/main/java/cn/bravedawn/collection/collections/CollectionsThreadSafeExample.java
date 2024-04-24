package cn.bravedawn.collection.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-11-02 15:29
 */
public class CollectionsThreadSafeExample {

    /**
     * 把线程不安全的集合变为线程安全的集合
     * Map、Set也有这样的API
     */


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        List<String> syncList = Collections.synchronizedList(list);
    }
}
