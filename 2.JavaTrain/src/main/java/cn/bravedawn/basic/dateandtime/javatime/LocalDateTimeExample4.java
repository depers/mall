package cn.bravedawn.basic.dateandtime.javatime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 10:43
 */
public class LocalDateTimeExample4 {

    /**
     * ISO 8601规定的日期和时间分隔符是T。标准格式如下：
     * 日期：yyyy-MM-dd
     * 时间：HH:mm:ss
     * 带毫秒的时间：HH:mm:ss.SSS
     * 日期和时间：yyyy-MM-dd'T'HH:mm:ss
     * 带毫秒的日期和时间：yyyy-MM-dd'T'HH:mm:ss.SSS
     */

    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.parse("2019-11-19T15:16:17");
        LocalDate d = LocalDate.parse("2019-11-19");
        LocalTime t = LocalTime.parse("15:16:17");
    }
}
