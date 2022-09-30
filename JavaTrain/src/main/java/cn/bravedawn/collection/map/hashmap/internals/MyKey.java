package cn.bravedawn.collection.map.hashmap.internals;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/29 20:02
 */
public class MyKey {

    /**
     * 我们使用这个类对象作为map的key时，map的hash()方法会调用该对象的hashcode()方法计算哈希值
     */

    private int id;

    public MyKey(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyKey myKey = (MyKey) o;
        return id == myKey.id;
    }

    @Override
    public int hashCode() {
        System.out.println("Calling hashCode()");
        return Objects.hash(id);
    }


    public static void main(String[] args) {
        MyKey key = new MyKey(1);
        Map<MyKey, String> map = new HashMap<>();
        map.put(key, "val"); // 此时控制台上会打印 Calling hashCode()
        map.get(key);
    }
}
