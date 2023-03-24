package cn.bravedawn.java8.stream.collect;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToMapExample {


    /**
     * stream流输出集合map
     */

    public static void main(String[] args) {

        Stream<String[]> stream = Stream.of(new String[][]{{"a", "123"}, {"b", "456"}, {"c", "789"}});
        Map<String, String> collect = stream.collect(Collectors.toMap(p -> p[0], p -> p[1]));
        System.out.println(collect);
    }


}
