package cn.bravedawn.chapter18.utils;

import java.util.UUID;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 11:45
 */
public class IdUtil {

    public static String randomId() {
        return UUID.randomUUID().toString().substring(0, 4);
    }
}
