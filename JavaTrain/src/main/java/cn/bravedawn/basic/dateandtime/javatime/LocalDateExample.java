package cn.bravedawn.basic.dateandtime.javatime;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/7/2 14:12
 */
public class LocalDateExample {

    /**
     * 默认只输出时间
     */

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2024, 5, 31);
        System.out.println(localDate);

        LocalDate originalDate = localDate.minusMonths(1);
        long between = ChronoUnit.DAYS.between(originalDate, localDate);
        System.out.println(between);
        System.out.println(originalDate);

        long monthBetween = ChronoUnit.MONTHS.between(originalDate, LocalDate.now());
        System.out.println(monthBetween);
    }
}
