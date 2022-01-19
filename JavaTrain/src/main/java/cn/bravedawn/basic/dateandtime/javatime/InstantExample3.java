package cn.bravedawn.basic.dateandtime.javatime;

import java.time.Instant;
import java.time.ZonedDateTime;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 15:28
 */
public class InstantExample3 {

    /**
     * ZonedDateTime可以转化为Instant和时间戳
     */

    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        Instant instant = now.toInstant();
        long timestamp = now.toEpochSecond();

        System.out.println(instant);
        System.out.println(timestamp);
    }
}
