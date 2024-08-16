package cn.bravedawn.basic.dateandtime.javautil;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/8/15 11:08
 */
public class DateExample4 {

    public static void main(String[] args) {

        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(sdf.format(date));
        System.out.println(date.getTime());
    }
}
