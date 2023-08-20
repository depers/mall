package cn.bravedawn.basic.dateandtime.javautil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 8:32
 */
public class TimeZoneExample2 {

    /**
     * 利用Calendar进行时区转换的步骤：
     * 1.清除所有字段；
     * 2.设定指定时区；
     * 3.设定日期和时间；
     * 4.创建SimpleDateFormat并设定目标时区；
     * 5.格式化获取的Date对象（注意Date对象无时区信息，时区信息存储在SimpleDateFormat中）；
     *
     * 本质上时区转换只能通过SimpleDateFormat在显示的时候完成
     */

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        // 清除所有字段
        c.clear();
        // 设置为北京时间
        c.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        // 设置年月日时分秒:
        c.set(2019, 10 /* 11月 */, 20, 8, 15, 0);
        // 显示时间:
        var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(c.getTime())); // 2019-11-20 08:15:00

        sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println(sdf.format(c.getTime())); // 2019-11-19 19:15:00
    }
}
