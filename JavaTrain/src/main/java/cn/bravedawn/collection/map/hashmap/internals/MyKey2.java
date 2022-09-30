package cn.bravedawn.collection.map.hashmap.internals;

import java.util.HashMap;
import java.util.Objects;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/30 13:26
 */
public class MyKey2 {

    private String name;
    private int id;

    public MyKey2(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Calling equals() for key: " + o);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyKey2 myKey2 = (MyKey2) o;
        return id == myKey2.id && Objects.equals(name, myKey2.name);
    }

    @Override
    public int hashCode() {
        System.out.println("Calling hashCode()");
        return id;
    }

    @Override
    public String toString() {
        return "MyKey2{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public static void main(String[] args) {
        HashMap<MyKey2, String> map = new HashMap<>();
        MyKey2 k1 = new MyKey2(1, "firstKey");
        MyKey2 k2 = new MyKey2(2, "secondKey");
        MyKey2 k3 = new MyKey2(2, "thirdKey");

        System.out.println("storing value for k1");
        map.put(k1, "firstValue");
        System.out.println("storing value for k2");
        map.put(k2, "secondValue");
        System.out.println("storing value for k3");
        map.put(k3, "thirdValue");
        System.out.println("---------------------------");

        System.out.println("retrieving value for k1");
        String v1 = map.get(k1);
        System.out.println("retrieving value for k2");
        String v2 = map.get(k2);
        System.out.println("retrieving value for k3");
        String v3 = map.get(k3);
        System.out.println("---------------------------");

        System.out.println("firstValue".equals(v1));
        System.out.println("secondValue".equals(v2));
        System.out.println("thirdValue".equals(v3));
    }
}
