package cn.bravedawn.basic.dateandtime.javautil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 7:57
 */
public class SimpleDateFormatExample {

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }
}
