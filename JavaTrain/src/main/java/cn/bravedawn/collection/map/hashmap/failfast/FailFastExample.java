package cn.bravedawn.collection.map.hashmap.failfast;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/30 7:52
 */
public class FailFastExample {

    /**
     * Fail fast迭代器
     * 在迭代器创建之后，结构被除迭代器自己的remove()方法之外的任何方法修改时。
     * 这里我们使用了map的put()方法
     */

    public static void main(String[] args) {
        Map<String,String> premiumPhone = new HashMap<String,String>();
        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S5");

        Iterator iterator = premiumPhone.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(premiumPhone.get(iterator.next())); // java.util.ConcurrentModificationException
            premiumPhone.put("Sony", "Xperia Z");
        }
    }
}
