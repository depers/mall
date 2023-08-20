package cn.bravedawn.basic.dateandtime.javatime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 13:46
 */
public class DurationExample {

    /**
     * Duration表示两个时刻之间的时间间隔，Duration的表示方法也符合ISO 8601的格式
     */

    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
        LocalDateTime end = LocalDateTime.of(2020, 1, 9, 19, 25, 30);
        Duration d = Duration.between(start, end);
        System.out.println(d); // PT1235H10M30S，表示1235小时10分钟30秒
    }
}
