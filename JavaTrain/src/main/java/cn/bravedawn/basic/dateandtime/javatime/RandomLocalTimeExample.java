package cn.bravedawn.basic.dateandtime.javatime;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomLocalTimeExample {

    /**
     * 生成 00:00:00到 11.59.59分的随机时间
     */

    public static void main(String[] args) {
        System.out.println(generateTimeByThreadLocalRandom());
        System.out.println(generateTimeByRandom());

    }

    public static LocalTime generateTimeByThreadLocalRandom() {
        int randomTime = ThreadLocalRandom
                .current()
                .nextInt(LocalTime.MIN.toSecondOfDay(), LocalTime.MAX.toSecondOfDay());

        return LocalTime.ofSecondOfDay(randomTime);
    }

    public static LocalTime generateTimeByRandom() {
        Random random = new Random();
        int anInt = random.nextInt(LocalTime.MIN.toSecondOfDay(), LocalTime.MAX.toSecondOfDay());
        return LocalTime.ofSecondOfDay(anInt);
    }
}
