package cn.bravedawn.basic.dateandtime.javatime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 10:45
 */
public class DateTimeFormatterExample {

    /**
     * 自定义输出的格式，或者要把一个非ISO 8601格式的字符串解析成LocalDateTime
     */

    public static void main(String[] args) {
        // 自定义时间格式化
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));

        // 自定义格式解析为LocalDateTime
        LocalDateTime dt2 = LocalDateTime.parse("2022/01/19 10:47:01", dtf);
        System.out.println(dt2);
    }
}
