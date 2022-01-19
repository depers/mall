package cn.bravedawn.basic.dateandtime.javatime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 13:56
 */
public class PeriodExample {

    /**
     * Period表示两个日期之间的天数
     */

    public static void main(String[] args) {
        Period p = LocalDate.of(2019, 11, 19).until(LocalDate.of(2020, 1, 9));
        System.out.println(p); // P1M21D，表示1个月21天
    }
}
