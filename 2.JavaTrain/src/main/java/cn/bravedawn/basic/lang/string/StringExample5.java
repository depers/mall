package cn.bravedawn.basic.lang.string;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/6/25 11:14
 */
public class StringExample5 {

    /**
     * 比较两个时间字符串的大小，建议还是转换成时间来做比较
     */

    public static void main(String[] args) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalTime time1 = LocalTime.now(ZoneId.of("Asia/Shanghai"));
        LocalTime time2 = LocalTime.now(ZoneId.of("Asia/Shanghai"));

        time1 = time1.minusHours(2);

        String timeStr1 = dtf.format(time1);
        String timeStr2 = dtf.format(time2);

        System.out.println("Time1: " + timeStr1);
        System.out.println("Time2: " + timeStr2);

        System.out.println(timeStr1.compareTo(timeStr2));

    }
}
