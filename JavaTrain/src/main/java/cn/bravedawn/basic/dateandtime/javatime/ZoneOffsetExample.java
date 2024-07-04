package cn.bravedawn.basic.dateandtime.javatime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/7/2 14:15
 */
public class ZoneOffsetExample {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        // 时区
        System.out.println(now.atZone(ZoneId.of("Asia/Shanghai")).toEpochSecond());
        // 时区偏移量
        System.out.println(now.atOffset(ZoneOffset.of("+8")).toEpochSecond());
    }
}
