package cn.bravedawn.basic.dateandtime.javatime;

import java.time.LocalDate;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/8/21 10:09
 */
public class LocalDateExample3 {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now().minusDays(1);

        LocalDate beforeDay5 = localDate.minusDays(4);
        System.out.println(beforeDay5);

        System.out.println(localDate.isAfter(beforeDay5));
        System.out.println(localDate.isEqual(LocalDate.now().minusDays(1)));
    }
}
