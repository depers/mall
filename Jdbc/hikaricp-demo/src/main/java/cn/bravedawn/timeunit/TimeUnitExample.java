package cn.bravedawn.timeunit;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @Author : fengx9
 * @Project : hikaricp-demo
 * @Date : Created in 2023-11-27 10:14
 */
public class TimeUnitExample {

    /**
     * 将30秒转为毫秒
     */

    public static void main(String[] args) {
        long millis = SECONDS.toMillis(30);
        System.out.println(millis);
    }
}
