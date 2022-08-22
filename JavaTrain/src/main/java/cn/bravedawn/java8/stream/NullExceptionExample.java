package cn.bravedawn.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NullExceptionExample {

    /**
     * stream调用的集合对象若为null则会报空指针异常，若为空会自动不执行stream操作
     */


    public static void main(String[] args) {
        List<String> listOne = new ArrayList<>();
        List<String> listTwo = Arrays.asList("a", "b");
        List<String> listThree = null;

        System.out.println(listOne.isEmpty()); // true
        System.out.println(listTwo.isEmpty()); // false

        listOne.stream().forEach(System.out::println); // 跳过
        listTwo.stream().forEach(System.out::println); // a b
//        listThree.stream().forEach(System.out::println); // NullPointerException
    }
}
