package cn.bravedawn.basic.dateandtime.javatime;

import java.time.LocalDateTime;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 10:53
 */
public class LocalDateTimeExample6 {


    public static void main(String[] args) {

        /**
         * 修改日期
         * 调整年：withYear()
         * 调整月：withMonth()
         * 调整日：withDayOfMonth()
         * 调整时：withHour()
         * 调整分：withMinute()
         * 调整秒：withSecond()
         */

        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);

        LocalDateTime dt2 = dt.withDayOfMonth(20);
        System.out.println(dt2);

        LocalDateTime dt3 = dt2.withMonth(9);
        System.out.println(dt3);


    }
}
