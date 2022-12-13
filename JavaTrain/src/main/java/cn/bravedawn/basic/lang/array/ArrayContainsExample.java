package cn.bravedawn.basic.lang.array;

import java.util.Arrays;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/5 19:13
 */
public class ArrayContainsExample {

    /**
     * 数组没有contains方法，需要借助List集合去实现
     */

    public static void main(String[] args) {
        String[] arr = {"a", "b", "c"};
        List<String> list = Arrays.asList(arr);
        System.out.println(list.contains("a"));

    }
}
