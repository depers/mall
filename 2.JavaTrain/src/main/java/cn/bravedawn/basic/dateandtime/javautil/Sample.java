package cn.bravedawn.basic.dateandtime.javautil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sample {


    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        System.out.println("startTime：" + startTime);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        Thread.sleep(10000);
        long endTime = System.currentTimeMillis();
        System.out.println("endTime：" + endTime);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        System.out.println((endTime - startTime) / 1000);
    }
}
