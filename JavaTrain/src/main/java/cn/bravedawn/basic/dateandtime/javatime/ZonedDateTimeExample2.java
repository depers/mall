package cn.bravedawn.basic.dateandtime.javatime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 14:05
 */
public class ZonedDateTimeExample2 {

    /**
     * 通过LocalDateTime附加一个ZoneId，就可以创建ZonedDateTime
     */

    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.of(2019, 9, 15, 15, 16, 17);
        ZonedDateTime zbj = ldt.atZone(ZoneId.systemDefault());
        ZonedDateTime zny = ldt.atZone(ZoneId.of("America/New_York"));

        System.out.println(zbj);
        System.out.println(zny);
    }
}
