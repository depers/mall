package cn.bravedawn.collection.list.copylist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/19 13:20
 */
public class CopyListExample4 {

    /**
     * 拷贝列表中的元素到另一个列表：第四种方法是适用Java8 stream，他除了拷贝外还提供了skip()和filter()等功能
     */

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "b", "c", "d");
        List<String> copy = list.stream().collect(Collectors.toList());
        System.out.println(copy); // [apple, b, c, d]

        List<String> copy2 = list.stream().skip(1).collect(Collectors.toList());
        System.out.println(copy2); // [b, c, d]

        List<String> copy3 = list.stream().filter(s -> s.length() > 1).collect(Collectors.toList());
        System.out.println(copy3); // [apple]
    }
}
