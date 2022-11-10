package cn.bravedawn.java8.stream.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/10 15:59
 */
public class CollectorsExample3 {

    /**
     * Collectors.toList，将原来的Stream映射为一个单元素流，然后收集为List。
     * Collectors.toSet，将特定信息收集为一个set，可以去重复。
     * Collectors.toMap，将特定信息收集为一个map。
     */


    static class People {

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

        public People(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }


    public static void main(String[] args) {
        People p1 = new People("小明", 18);
        People p2 = new People("小蓝", 11);
        People p3 = new People("小白", 19);
        People p4 = new People("小美", 11);

        List<People> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        List<Integer> ageList = list.stream().map(People::getAge).toList();
        Set<Integer> ageSet = list.stream().map(People::getAge).collect(Collectors.toSet());
        Map<String, Integer> peopleMap = list.stream().collect(Collectors.toMap(People::getName, People::getAge));

        System.out.println(ageList);
        System.out.println(ageSet);
        System.out.println(peopleMap);

    }
}
