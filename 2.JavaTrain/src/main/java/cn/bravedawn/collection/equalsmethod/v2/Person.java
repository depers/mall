package cn.bravedawn.collection.equalsmethod.v2;

import java.util.Objects;

/**
 * @author : fengx9
 * @program : JavaTrain
 * @date : Created in 2022/04/27 11:35 AM
 */
public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
