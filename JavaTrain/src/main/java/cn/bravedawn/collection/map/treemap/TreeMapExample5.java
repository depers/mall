package cn.bravedawn.collection.map.treemap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Description : TODO
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-10-25 16:28
 */
public class TreeMapExample5 {


    public static void main(String[] args) {
        Map<Student, Integer> map = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.score == o2.score) {
                    return 0;
                }
                // 按照分数从高到低依次排序
                return o1.score > o2.score ? -1 : 1;
            }
        });

        map.put(new Student("Tom", 77), 1);
        map.put(new Student("Bob", 66), 2);
        map.put(new Student("Lily", 99), 3);
        for (Student key : map.keySet()) {
            System.out.println(key);
        }

        // TreeMap的get方法是通过Key的compareTo()方法或是Comparator.compare()方法获取的
        System.out.println(map.get(new Student("Bob", 66)));
    }
}
