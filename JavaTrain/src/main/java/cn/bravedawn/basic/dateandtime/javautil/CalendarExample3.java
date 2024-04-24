package cn.bravedawn.basic.dateandtime.javautil;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 7:59
 */
public class CalendarExample3 {

    public static void main(String[] args) {
        // 当前时间
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTimeZone().getID());


        var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.getTimeZone().getID());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                                .format(calendar.getTime()));
    }
}
