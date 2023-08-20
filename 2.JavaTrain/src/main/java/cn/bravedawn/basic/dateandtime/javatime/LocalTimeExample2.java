package cn.bravedawn.basic.dateandtime.javatime;

import java.time.LocalTime;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/1/10 10:46
 */
public class LocalTimeExample2 {

    /**
     * 构建LocalTime并判断时间先后
     */
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.of(19, 30, 0);
        LocalTime localTime2 = LocalTime.of(7, 30, 0);
        LocalTime now = LocalTime.of(0, 0, 0);
        LocalTime now2 = LocalTime.of(20, 0, 0);
        System.out.println(now.getHour());

        System.out.println(now2.isAfter(localTime));
        System.out.println(now.isBefore(localTime2));
    }
}
