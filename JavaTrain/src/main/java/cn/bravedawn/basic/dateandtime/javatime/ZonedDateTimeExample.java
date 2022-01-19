package cn.bravedawn.basic.dateandtime.javatime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 14:00
 */
public class ZonedDateTimeExample {

    /**
     * 创建ZonedDateTime获取当前时间
     */

    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York")); // 用指定时区获取当前时间

        System.out.println(zbj);
        System.out.println(zny);
    }
}
