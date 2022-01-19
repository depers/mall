package cn.bravedawn.basic.dateandtime.javatime;


import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 15:58
 */
public class BestPractice3 {

    /**
     * 数据库中存储时间存储为长整型数long，数据库中是BIGINT
     * 通过存储一个long型时间戳，我们可以编写一个timestampToString()的方法，非常简单地为不同用户以不同的偏好来显示不同的本地时间：
     */

    public static void main(String[] args) {
        long ts = 1574208900000L;
        System.out.println(timestampToString(ts, Locale.CHINA, "Asia/Shanghai"));
        System.out.println(timestampToString(ts, Locale.US, "America/New_York"));
    }


    static String timestampToString(long epochMilli, Locale lo, String zoneId) {
        Instant instant = Instant.ofEpochMilli(epochMilli);
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);
        return f.withLocale(lo).format(ZonedDateTime.ofInstant(instant, ZoneId.of(zoneId)));

    }
}
