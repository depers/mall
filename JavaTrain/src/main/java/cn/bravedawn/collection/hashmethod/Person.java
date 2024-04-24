package cn.bravedawn.collection.hashmethod;

import java.util.Objects;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/5/19 11:55
 */
public class Person {

    /**
     * 实现equals和hashCode方法
     */

    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
