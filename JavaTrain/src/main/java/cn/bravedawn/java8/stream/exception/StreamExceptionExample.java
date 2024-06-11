package cn.bravedawn.java8.stream.exception;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/5/29 16:19
 */
public class StreamExceptionExample {


    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 0);
        list.stream().map(i -> 10 / i).forEach(System.out::println); // 这里会抛出异常


    }
}
