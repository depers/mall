package cn.bravedawn.basic.dateandtime.javautil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample3 {

    /**
     * 为Date设置时间相关字段
     */

    public static void main(String[] args) {
        Date date = new Date();
        date.setHours(23);
        date.setMinutes(59);
        date.setSeconds(59);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }
}
