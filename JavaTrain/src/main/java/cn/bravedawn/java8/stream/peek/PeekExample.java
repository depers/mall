package cn.bravedawn.java8.stream.peek;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PeekExample {


    /**
     * stream流中peek操作的使用
     *
     * peek()方法存在的主要目的是用调试，通过peek()方法可以看到流中的数据经过每个处理点时的状态。
     */

    public static void main(String[] args) {


        List<Integer> list = List.of(1, 2, 3, 4, 5);

        // peek()不起作用的原因是peek()是一个中间操作，而且我们没有提供一个终止操作。
        list.stream().peek(System.out::println);

        // 在下面这个方法中必须使用collect操作才能将peek中的操作执行
        list.stream().peek(System.out::println).collect(Collectors.toList());
    }
}
