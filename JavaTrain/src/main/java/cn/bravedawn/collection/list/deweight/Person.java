package cn.bravedawn.collection.list.deweight;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/8/14 11:14
 */
public class Person {

    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
