package cn.bravedawn.basic.random;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/25 13:24
 */
public class RandomIntsJava8 {

    /**
     * java8提供了新的方法生成IntStream
     */


    public static void main(String[] args) {
        Random random = new Random();
        int streamSize = 10;
        int min = 0;
        int max = 100;

        // 不带形参的ints方法返回无限的int值流:
        //IntStream unlimitedIntStream = random.ints();
        //System.out.println(unlimitedIntStream.max().getAsInt());

        // 传入一个参数来限制流的大小
        IntStream limitedIntStream = random.ints(streamSize);
        System.out.println(Arrays.toString(limitedIntStream.toArray()));

        // 除了限制流的大小，还可以为生成的范围设置最大值和最小值
        IntStream limitedIntStreamWithinARange = random.ints(streamSize, min, max);
        System.out.println(Arrays.toString(limitedIntStreamWithinARange.toArray()));


    }
}
