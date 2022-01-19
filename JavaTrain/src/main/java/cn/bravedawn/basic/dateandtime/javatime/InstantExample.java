package cn.bravedawn.basic.dateandtime.javatime;

import java.time.Instant;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 14:31
 */
public class InstantExample {

    /**
     * 用Instant.now()获取当前时间戳，效果和System.currentTimeMillis()类似
     */

    public static void main(String[] args) {
        Instant now = Instant.now();

        System.out.println(now.getEpochSecond()); // 秒
        System.out.println(now.toEpochMilli());   // 毫秒
        System.out.println(System.currentTimeMillis()); // 毫秒
    }
}
