package cn.bravedawn.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/4/28 15:19
 */
public class MaxAndMinExample {

    /**
     * 获取一个列表中的最大值和最小值
     */

    public static void main(String[] args) {
        // 获取列表中的最大值或是最小值
        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);
        idList.add(3);
        idList.add(4);
        Optional<Integer> max = idList.stream().max(Integer::compareTo);
        System.out.println("max: " + max.get());


        // 获取一个对象列表中的最大值
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("fengxiao", 11));
        studentList.add(new Student("liming", 18));
        studentList.add(new Student("zhanghua", 27));
        int minAge = studentList.stream().map(Student::getAge).min(Integer::compareTo).get();
        System.out.println("minAge: " + minAge);
    }

    static class Student{
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

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
    }
}
