package cn.bravedawn.basic.random;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/25 16:39
 */
public class ThreadLocalRandomExample {

    /**
     * 多线程环境下生成随机数
     *
     * ThreadLocalRandom实例在密码学上是不安全的
     */


    public static void main(String[] args) {
        int min = 0;
        int max = 100;
        int streamSize = 10;

        int randomWithThreadLocalRandomInRange = ThreadLocalRandom.current().nextInt(min, max);
        System.out.println(randomWithThreadLocalRandomInRange);

        int randomWithThreadLocalRandom = ThreadLocalRandom.current().nextInt();
        System.out.println(randomWithThreadLocalRandom);

        int randomWithThreadLocalRandomFromZero = ThreadLocalRandom.current().nextInt(max);
        System.out.println(randomWithThreadLocalRandomFromZero);

        IntStream streamWithThreadLocalRandom = ThreadLocalRandom.current().ints(streamSize, min, max);
        System.out.println(Arrays.toString(streamWithThreadLocalRandom.toArray()));
    }
}
