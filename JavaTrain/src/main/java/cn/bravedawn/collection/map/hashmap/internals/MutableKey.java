package cn.bravedawn.collection.map.hashmap.internals;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/29 13:10
 */
public class MutableKey {

    /**
     * 在大多数情况下，我们应该在HashMap中使用不可变键，或者至少，我们必须意识到使用可变键的后果
     * 下面就演示了使用可变键的后果，会导致hashcode重新计算，用错误的hashcode去错误的bucket里搜索，是找不到原来的value值，会返回null
     */

    private String name;

    public MutableKey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MutableKey that = (MutableKey) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    @Override
    public String toString() {
        return "MutableKey{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        MutableKey key = new MutableKey("initial");
        Map<MutableKey, String> items = new HashMap<>();
        items.put(key, "success");
        System.out.println(key); // MutableKey{name='initial'}

        key.setName("changed");
        System.out.println(items.get(key)); // null
    }
}
