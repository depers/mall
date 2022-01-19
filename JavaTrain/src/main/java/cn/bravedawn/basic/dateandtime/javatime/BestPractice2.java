package cn.bravedawn.basic.dateandtime.javatime;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 15:44
 */
public class BestPractice2 {

    /**
     * 新API转旧API：
     * 如果要把新的ZonedDateTime转换为旧的API对象，只能借助long型时间戳做一个“中转”
     */

    public static void main(String[] args) {
        // ZonedDateTime -> long:
        ZonedDateTime zdt = ZonedDateTime.now();
        long ts = zdt.toEpochSecond() * 1000;

        // long -> Date:
        Date date = new Date(ts);

        // long -> Calendar:
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTimeZone(TimeZone.getTimeZone(zdt.getZone().getId()));
        calendar.setTimeInMillis(zdt.toEpochSecond() * 1000);
    }
}
