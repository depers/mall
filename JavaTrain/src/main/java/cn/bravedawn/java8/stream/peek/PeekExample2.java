package cn.bravedawn.java8.stream.peek;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PeekExample2 {


    /**
     * stream流中peek操作的使用
     *
     * peek()在需要修改元素内部状态的场景也非常有用，比如我们想将所有Person的名字修改为大写，
     * 当然也可以使用map()和flatMap实现，但是相比来说peek()更加方便，因为我们并不想替代流中的数据，我们想保留原有的数据
     *
     */

    public static void main(String[] args) {
        Person a = new Person("a", 18);
        Person b = new Person("b", 23);
        Person c = new Person("c", 34);
        Stream<Person> persons = Stream.of(a, b, c);
        persons.peek(person -> person.setName(person.getName().toUpperCase()))
                .forEach(System.out::println);

        System.out.println(a);
        System.out.println("-----------------------------------");

        // 使用map的话需求重新生成新的对象，也就是上面说的替代流中的数据
        Person d = new Person("a", 18);
        Person e = new Person("b", 23);
        Person f = new Person("c", 34);
        Stream<Person> persons2 = Stream.of(d, e, f);
        persons2.map(p -> new Person(p.getName().toUpperCase(), p.getAge()))
                .forEach(System.out::println);
        System.out.println(d);
    }


    static class Person {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}' + super.toString();
        }
    }
}
