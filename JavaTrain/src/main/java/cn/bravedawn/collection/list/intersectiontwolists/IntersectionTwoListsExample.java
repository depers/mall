package cn.bravedawn.collection.list.intersectiontwolists;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/23 22:00
 */
public class IntersectionTwoListsExample {

    /**
     * 两个字符串列表的交集
     */

    public static void main(String[] args) {
        List<String> list = Arrays.asList("red", "blue", "blue", "green", "red");
        List<String> otherList = Arrays.asList("red", "green", "green", "yellow");

        Set<String> result = list.stream()
                .distinct()
                .filter(otherList::contains)
                .collect(Collectors.toSet());

        System.out.println(result); // [red, green]

    }
}
