package cn.bravedawn.basic.dateandtime.javatime;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 14:15
 */
public class DateTimeFormatterExample2 {

    /**
     * 创建DateTimeFormatter
     */


    public static void main(String[] args) {
        // 方式一：直接传入格式化字符串实现
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // 方式二：传入格式化字符串时，同时指定Locale
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, yyyy-MMMM-dd HH:mm", Locale.US);

    }
}
