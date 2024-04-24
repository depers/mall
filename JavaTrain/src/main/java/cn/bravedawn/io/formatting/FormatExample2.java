package cn.bravedawn.io.formatting;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class FormatExample2 {


    /**
     * format针对时间和日期的表示
     * tm：两位数字的月份（Calendar的月份是从0开始的）
     * te：月份里的天数
     * tY：四位数字的年份
     */

    public static void main(String[] args) {
        Calendar c = new GregorianCalendar(2017, 11, 10);
        String s = String.format(
                "The date is: %tm %1$te,%1$tY", c);
        System.out.println(s);
    }
}
