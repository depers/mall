package cn.bravedawn.java8.stream.collect;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/14 10:53
 */
public class CollectorsExample4 {

    /**
     * 将字符串数组使用分隔符进行拼接，转换为字符串
     */

    public static void main(String[] args) {
        String[] animals = new String[] { "Dog", "Cat", "Bird", "Cow" };
        String result = Arrays.stream(animals).collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
