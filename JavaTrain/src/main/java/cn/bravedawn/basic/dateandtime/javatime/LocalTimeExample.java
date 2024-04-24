package cn.bravedawn.basic.dateandtime.javatime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeExample {

    /**
     * 演示如何使用 LocalTime.MIN
     */


    public static void main(String[] args) {
        String dateTime = "2022.08.05";
        LocalDate ld = LocalDate.parse(dateTime, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        LocalDateTime ldt = ld.atTime(LocalTime.MIN);
        System.out.println(ldt);
    }
}
