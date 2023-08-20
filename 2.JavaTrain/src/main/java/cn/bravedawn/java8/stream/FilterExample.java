package cn.bravedawn.java8.stream;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/1/4 14:25
 */
public class FilterExample {

    public static void main(String[] args) {
        String[] strings = {"a", "b", "c"};
        List<String> list = Lists.newArrayList(strings);
        List<String> collect = list.stream().filter(str -> !str.equals("b"))
                .map(str -> str + "a")
                .collect(Collectors.toList());

        System.out.println(collect.toString());
    }
}
