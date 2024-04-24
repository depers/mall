package cn.bravedawn.collection.equalsmethod.v1;

import java.util.List;

/**
 * @author : fengx9
 * @program : JavaTrain
 * @date : Created in 2022/04/27 11:36 AM
 */
public class EqualsExample {

    /**
     * list的contains里面是通过元素对象的equals方法进行判断的，所以需要元素对象的equals进行覆写
     */


    public static void main(String[] args) {
        List<Person> list = List.of(
                new Person("Xiao Ming"),
                new Person("Xiao Hong"),
                new Person("Bob")
        );

        System.out.println(list.contains(new Person("Bob"))); // false
    }
}
