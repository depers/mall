package cn.bravedawn.basic.dateandtime.javautil;

import java.util.Date;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 7:46
 */
public class DateExample {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.getYear() + 1900);  // 必须加上1900
        System.out.println(date.getMonth() + 1);    // 0~11，必须加上1
        System.out.println(date.getDate());         // 1~31，不能加1

        // 转换为String:
        System.out.println(date.toString());
        // 转换为GMT时区:
        System.out.println(date.toGMTString());
        // 转换为本地时区:
        System.out.println(date.toLocaleString());
    }
}
