package cn.bravedawn.test;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2024-01-10 14:15
 *
 * 使用Fixture，编写测试前准备、测试后清理的固定代码，我们称之为Fixture
 */
public class Calculator {

    private long n = 0;

    public long add(long x) {
        n = n + x;
        return n;
    }

    public long sub(long x) {
        n = n - x;
        return n;
    }
}
