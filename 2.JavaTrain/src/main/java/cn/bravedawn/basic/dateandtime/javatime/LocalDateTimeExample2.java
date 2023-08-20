package cn.bravedawn.basic.dateandtime.javatime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 10:33
 */
public class LocalDateTimeExample2 {

    /**
     * 为获取同一时刻的日期和时间，可以将LocalDateTime进行转换
     */

    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.now();
        LocalDate d = dt.toLocalDate();
        LocalTime t = dt.toLocalTime();
    }
}
