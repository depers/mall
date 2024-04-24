package cn.bravedawn.basic.dateandtime.javatime;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

/**
 * @author : depers
 * @program : 2.JavaTrain
 * @date : Created in 2024/4/15 13:51
 *
 * 判断该事件是否在参数时间之后
 */
public class IsAfterExample {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2012, 12, 1);
        LocalDate date2 = LocalDate.of(2024, 12, 1);
        LocalDate date3 = LocalDate.of(2024, 4, 15);
        LocalDate now = LocalDate.now();
        System.out.println(date.isAfter(now)); // false
        System.out.println(date2.isAfter(now)); // true
        System.out.println(date3.isAfter(now)); // false
        System.out.println(date3.isBefore(now)); // false
        System.out.println(date3.equals(now));
        System.out.println(date3);
        System.out.println(now);
        System.out.println(now.minusDays(1));
    }
}
