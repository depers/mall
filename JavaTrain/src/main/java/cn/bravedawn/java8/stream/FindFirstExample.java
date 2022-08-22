package cn.bravedawn.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FindFirstExample {

    /**
     * findFirst的使用
     */

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("1", "2", "3");
        Optional<String> first = strings.stream().findFirst();
        if (first.isPresent()) {
            System.out.println(first.get());
        }
    }
}
