package cn.bravedawn.basic.dateandtime.javatime;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 10:48
 */
public class LocalDateTimeExample5 {

    public static void main(String[] args) {

        /**
         * 日期的加减运算
         */

        LocalDateTime dt = LocalDateTime.of(2022, 1, 19, 10, 49, 1);
        System.out.println(dt);

        LocalDateTime dt2 = dt.plusDays(5).minusHours(3);
        System.out.println(dt2);

        LocalDateTime dt3 = dt2.minusMonths(1);
        System.out.println(dt3);
    }
}
