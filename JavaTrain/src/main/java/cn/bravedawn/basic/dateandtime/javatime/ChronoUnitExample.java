package cn.bravedawn.basic.dateandtime.javatime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/6/6 16:11
 */
public class ChronoUnitExample {


    public static void main(String[] args) {
        Date date = new Date();

        LocalDate localDate = LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
        LocalDate localDate2 = LocalDate.of(2024, 4, 6);

        System.out.println(ChronoUnit.MONTHS.between(localDate2, localDate));
    }
}
