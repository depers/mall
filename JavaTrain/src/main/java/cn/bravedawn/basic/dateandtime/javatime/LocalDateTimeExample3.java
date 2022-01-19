package cn.bravedawn.basic.dateandtime.javatime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 10:38
 */
public class LocalDateTimeExample3 {

    /**
     * 创建指定的日期和时间
     */

    public static void main(String[] args) {
        LocalDate d = LocalDate.of(2019, 11, 30);
        LocalTime t = LocalTime.of(15, 16, 17);
        LocalDateTime dt = LocalDateTime.of(2022, 1, 19, 10, 40, 10);
        LocalDateTime dt2 = LocalDateTime.of(d, t);
    }
}
