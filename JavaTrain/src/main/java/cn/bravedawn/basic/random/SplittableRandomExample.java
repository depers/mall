package cn.bravedawn.basic.random;

import java.util.Arrays;
import java.util.SplittableRandom;
import java.util.stream.IntStream;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/25 16:50
 */
public class SplittableRandomExample {

    /**
     * Java8新的快速生成器，用于并行计算的生成器。重要的是要知道实例不是线程安全的
     */

    public static void main(String[] args) {
        int min = 0;
        int max = 100;
        int streamSize = 10;

        SplittableRandom splittableRandom = new SplittableRandom();
        int randomWithSplittableRandom = splittableRandom.nextInt(min, max);
        System.out.println(randomWithSplittableRandom);

        IntStream limitedIntStreamWithinARangeWithSplittableRandom = splittableRandom.ints(streamSize, min, max);
        System.out.println(Arrays.toString(limitedIntStreamWithinARangeWithSplittableRandom.toArray()));
    }
}
