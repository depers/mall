package cn.bravedawn.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2024-01-10 14:29
 *
 * JUnit提供assertThrows()来期望捕获一个指定的异常
 * 第一个参数：具体异常
 * 第二个参数：Executable封装了我们要执行的会产生异常的代码
 */
public class Factorial2Test {


    @Test
    void testNegative() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Factorial2.fact(-1);
            }
        });
    }

    @Test
    void testNegativeOfJava8() {
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial2.fact(-1);
        });
    }
}
