package cn.bravedawn.basic.dateandtime.javautil;

import java.util.Calendar;
import java.util.Date;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/4/8 17:04
 */
public class TimestampExample {

    /**
     * 获取系统当前时间的时间戳
     * @param args
     */

    public static void main(String[] args) {

        // 方法一：获取系统时间的时间戳
        System.out.println(System.currentTimeMillis()); // 毫秒级
        System.out.println(System.currentTimeMillis()/1000); // 秒级

        // 方法二：通过Calendar API获取时间戳
        System.out.println(Calendar.getInstance().getTimeInMillis()); // 毫秒级
        System.out.println(Calendar.getInstance().getTimeInMillis()/1000); // 秒级

        // 方法三：通过Date API获取时间戳
        System.out.println(new Date().getTime()); // 毫秒级
    }
}
