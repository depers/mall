package cn.bravedawn.basic.dateandtime.javatime;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 14:11
 */
public class ZonedDateTimeExample4 {

    /**
     * 将ZonedDateTime转换为LocalDateTime，会直接丢弃了时区信息
     */

    public static void main(String[] args) {
        ZonedDateTime zdt = ZonedDateTime.now();
        LocalDateTime ldt = zdt.toLocalDateTime();

        System.out.println(zdt);
        System.out.println(ldt);
    }
}
