package cn.bravedawn.basic.dateandtime.javautil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 7:59
 */
public class CalendarExample4 {

    public static void main(String[] args) {
        // 当前时间:
        Calendar c = Calendar.getInstance();
        // 加5天并减去2小时:
        c.add(Calendar.DAY_OF_MONTH, 5);
        c.add(Calendar.HOUR_OF_DAY, -2);
        // 显示时间:
        var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = c.getTime();
        System.out.println(sdf.format(d));

    }
}
