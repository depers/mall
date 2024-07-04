package cn.bravedawn.basic.dateandtime.javatime;

import java.time.LocalDate;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/7/2 14:12
 */
public class LocalDateExample {

    /**
     * 默认只输出时间
     */

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
    }
}
