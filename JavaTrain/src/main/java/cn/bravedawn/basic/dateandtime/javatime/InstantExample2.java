package cn.bravedawn.basic.dateandtime.javatime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 14:53
 */
public class InstantExample2 {

    /**
     * 将一个时间戳转换为正常时间
     * 1.确定时间戳的单位是秒还是毫秒
     * 2.确定时区
     */

    public static void main(String[] args) {
        Instant ins = Instant.ofEpochSecond(1568568760);
        ZonedDateTime zdt = ins.atZone(ZoneId.systemDefault());
        System.out.println(zdt);
    }
}
