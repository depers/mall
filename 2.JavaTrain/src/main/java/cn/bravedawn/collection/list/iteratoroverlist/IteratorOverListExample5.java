package cn.bravedawn.collection.list.iteratoroverlist;

import java.util.Arrays;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/22 23:11
 */
public class IteratorOverListExample5 {


    /**
     * 方法五：使用Iterable.forEach()
     * 实现了Iterable接口的forEach方法的集合都可以使用
     */

    public static void main(String[] args) {
        List<String> countries = Arrays.asList("Germany", "Panama", "Australia");
        countries.forEach(System.out::println);
    }
}
