package cn.bravedawn.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MapExample {


    /**
     * 对每个元素进行处理并返回新流
     */

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "def", "ghi", "jkl");

        Stream<String> map = strings.stream().map(s -> s + "22");

        map.forEach(System.out::println);
    }
}
