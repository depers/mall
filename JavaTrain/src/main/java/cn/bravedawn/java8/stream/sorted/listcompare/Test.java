package cn.bravedawn.java8.stream.sorted.listcompare;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/8/12 16:39
 */
public class Test {

    /**
     * 编写List比较器
     */


    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

        Student s1 = new Student();
        s1.setName("小米");
        s1.setAge(18);
        s1.setBirthDay(new Date(96, 12, 21));

        Student s2 = new Student();
        s2.setName("小白");
        s2.setAge(18);
        s2.setBirthDay(new Date(101, 12, 21));


        Student s3 = new Student();
        s3.setName("小蓝");
        s3.setAge(18);

        s3.setBirthDay(new Date(88, 12, 21));

        list.add(s1);
        list.add(s2);
        list.add(s3);

        list.stream().sorted(new BirthDayComparator(new Date()))
                .forEach(System.out::println);

        System.out.println("----------");

        Student student = list.stream().min(new BirthDayComparator(new Date())).get();
        System.out.println(student);

    }
}
