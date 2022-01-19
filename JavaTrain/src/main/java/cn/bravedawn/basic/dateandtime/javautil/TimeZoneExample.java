package cn.bravedawn.basic.dateandtime.javautil;

import java.sql.Time;
import java.util.TimeZone;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 8:28
 */
public class TimeZoneExample {

    /**
     * 设置时区
     */

    public static void main(String[] args) {
        TimeZone tzDefault = TimeZone.getDefault();                 // 当前时区
        TimeZone tzGMT9 = TimeZone.getTimeZone("GMT+09:00");        // GMT+9:00时区
        TimeZone tzNY = TimeZone.getTimeZone("America/New_York");   // 纽约时区

        // 打印时区id
        System.out.println(tzDefault.getID());
        System.out.println(tzGMT9.getID());
        System.out.println(tzNY.getID());

    }
}
