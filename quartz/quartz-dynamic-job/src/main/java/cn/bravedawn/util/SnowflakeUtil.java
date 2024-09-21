package cn.bravedawn.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.RandomUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * @author : depers
 * @program : quartz-dynamic-job
 * @date : Created in 2024/9/21 13:49
 */
public class SnowflakeUtil {

    private static final Snowflake snowflake;


    static {
        long workId = getWorkId();
        long dataCenterId = getDataCenterId();
        snowflake = new Snowflake(workId, dataCenterId);
    }

    private static long getWorkId() {
        try {
            String hostAddress = Inet4Address.getLocalHost().getHostAddress();
            // 将字符串的每一个字符转为unicode码
            int[] ints = StringUtils.toCodePoints(hostAddress);
            int sum = 0;
            for (int b : ints) {
                sum += b;
            }
            return sum % 32;
        } catch (UnknownHostException e) {
            return RandomUtil.randomLong(0, 32);
        }
    }


    private static long getDataCenterId() {
        try {
            String hostName = SystemUtils.getHostName();
            int[] ints = StringUtils.toCodePoints(hostName);
            int sum = 0;
            for (int b : ints) {
                sum += b;
            }
            return sum % 32;
        } catch (Throwable e) {
            return RandomUtil.randomLong(0, 32);
        }
    }

    public static long getId() {
        return snowflake.nextId();
    }
}
