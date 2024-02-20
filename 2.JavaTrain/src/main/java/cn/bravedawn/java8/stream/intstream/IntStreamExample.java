package cn.bravedawn.java8.stream.intstream;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author : depers
 * @program : 2.JavaTrain
 * @date : Created in 2024/2/18 10:21
 */
public class IntStreamExample {

    // 指定生成数组的区间
    public static void main(String[] args) {
        Integer[] array = IntStream.range(0, 10).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(array));
    }
}
