package cn.bravedawn.basic.dateandtime.javautil;

import java.util.Calendar;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 7:59
 */
public class CalendarExample {

    /**
     * Calendar的基本使用方法
     * @param args
     */

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int millisecond = calendar.get(Calendar.MILLISECOND);

        System.out.println(year + "-" + month + "-" + day + " " + weekDay
                + " " + hour + ":" + minute + ":" + second + ":" + millisecond);
    }
}
