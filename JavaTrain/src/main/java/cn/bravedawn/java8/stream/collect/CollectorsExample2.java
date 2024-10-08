package cn.bravedawn.java8.stream.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/8/31 17:11
 */
public class CollectorsExample2 {

    /**
     * 查找不为数字的list元素
     *
     * 这里涉及的知识点有
     * 1. String.chars()
     * 2. filter()
     * 3. allMatch()
     * 4. collect()
     */


    public static void main(String[] args) {
        List<String> list = List.of("1", "2", "3");
        List<String> collect = list.stream().filter(str -> !str.chars().allMatch(c -> Character.isDigit(c))).collect(Collectors.toList());
        System.out.println(collect);  // []
        System.out.println(collect == null);  //false


        List<String> list2 = new ArrayList<>();
        list2.add("1");
        List<String> collect2 = list2.stream().filter(str -> !str.chars().allMatch(c -> Character.isDigit(c))).collect(Collectors.toList());
        System.out.println(collect2); // []
        System.out.println(collect2 == null);  // false
    }
}
