package cn.bravedawn.collection.equalsmethod;

import java.util.List;

/**
 * @author : fengx9
 * @program : JavaTrain
 * @date : Created in 2022/04/27 11:36 AM
 */
public class EqualsExample {


    public static void main(String[] args) {
        List<Person> list = List.of(
                new Person("Xiao Ming"),
                new Person("Xiao Hong"),
                new Person("Bob")
        );

        System.out.println(list.contains(new Person("Bob")));
    }
}
