package cn.bravedawn.basic.dateandtime.javatime;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 15:35
 */
public class BestPractice {

    /**
     * 旧API转新API：
     * 如果要把旧式的Date或Calendar转换为新API对象，可以通过toInstant()方法转换为Instant对象，再继续转换为ZonedDateTime
     */

    public static void main(String[] args) {
        // Date -> Instant:
        Date date = new Date();
        Instant ins1 = date.toInstant();


        // Calendar -> Instant -> ZonedDateTime:
        Calendar calendar = Calendar.getInstance();
        Instant ins2 = calendar.toInstant();
        ZonedDateTime zdt = ins2.atZone(calendar.getTimeZone().toZoneId());


    }
}
