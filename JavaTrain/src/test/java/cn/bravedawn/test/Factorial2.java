package cn.bravedawn.test;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2024-01-10 14:27
 *
 * 异常测试
 */
public class Factorial2 {

    public static long fact(long n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        long r = 1;
        for (long i = 1; i <= n; i++) {
            r = r * i;
        }
        return r;
    }
}
