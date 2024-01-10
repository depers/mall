package cn.bravedawn.test;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2024-01-10 14:10
 *
 * 编写Junit测试
 */
public class Factorial {

    /**
     * 阶乘
     */
    public static long fact(long n) {
        long r = 1;
        for (long i = 1; i <= n; i++) {
            r = r * i;
        }
        return r;
    }
}
