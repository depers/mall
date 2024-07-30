package cn.bravedawn.basic.dateandtime.javatime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/7/16 11:41
 *
 * 将LocalDate转换为LocalDateTime
 */
public class LocalDateExample2 {

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        LocalDateTime localDateTime = LocalDate.now().atStartOfDay();
        System.out.println(dtf.format(localDateTime));

        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        System.out.println(dtf.format(localDateTime2));

        LocalDateTime localDateTime3 = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        System.out.println(dtf.format(localDateTime3));
    }
}
