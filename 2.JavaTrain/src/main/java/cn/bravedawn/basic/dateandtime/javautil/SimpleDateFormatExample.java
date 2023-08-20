package cn.bravedawn.basic.dateandtime.javautil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 7:57
 */
public class SimpleDateFormatExample {

    /**
     * SimpleDateFormat的使用
     */

    public static void main(String[] args) throws ParseException {
        // 将Date按照格式转为字符串
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));

        // 将字符串按照格式转为Date
        String dateStr = "2022-12-07";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parseDate = simpleDateFormat.parse(dateStr);
        System.out.println(parseDate); // Wed Dec 07 00:00:00 CST 2022
        Date now = new Date();
        System.out.println(parseDate.before(now)); // true

    }
}
