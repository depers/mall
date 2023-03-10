package cn.bravedawn.java8.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PeekExample {


    /**
     * stream流中peek操作的使用
     *
     * peek方法主要用于调试，以便在元素流过管道中的某个点时查看它们
     */

    public static void main(String[] args) {


        List<Integer> list = List.of(1, 2, 3, 4, 5);

        // 在下面这个方法中必须使用collect操作才能将peek中的操作执行
        list.stream().peek(System.out::println).collect(Collectors.toList());
    }
}
