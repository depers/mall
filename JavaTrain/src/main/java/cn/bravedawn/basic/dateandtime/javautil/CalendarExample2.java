package cn.bravedawn.basic.dateandtime.javautil;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 7:59
 */
public class CalendarExample2 {

    public static void main(String[] args) {
        // 当前时间
        Calendar calendar = Calendar.getInstance();

        // 清除所有字段
        calendar.clear();

        // 手动设置信息
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, 8);
        calendar.set(Calendar.DATE, 2);

        calendar.set(Calendar.HOUR_OF_DAY, 21);
        calendar.set(Calendar.MINUTE, 22);
        calendar.set(Calendar.SECOND, 23);


        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                                .format(calendar.getTime()));
    }
}
