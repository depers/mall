package cn.bravedawn.java8.stream;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 2022/08/30
 */
public class CollectorsExample {

    /**
     * 1.学习使用Collectors.groupingBy对集合进行分组
     * 2.对于分组后的子集合，没有得到分组的子集合为null
     */

    public static void main(String[] args) {
        List<String> stringList = List.of("1", "2", "3");

        // 将是数字和不是数字的进行分组
        Map<Boolean, List<String>> collect = stringList.stream().collect(Collectors.groupingBy(str -> str.chars().allMatch(Character::isDigit), Collectors.toList()));
        System.out.println(collect);  // {true=[1, 2, 3]}
        System.out.println(collect.get(true));  // [1, 2, 3]
        System.out.println(collect.get(false)); // null

    }
}
