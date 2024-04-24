package cn.bravedawn.java8.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description : TODO
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-10-23 18:06
 */
public class StreamExample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.stream().forEach(System.out::println);
    }
}
