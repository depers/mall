package cn.bravedawn.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2024-01-10 14:11
 *
 * 单元测试
 * 其他断言方法：
 *  assertTrue(): 期待结果为true
 *  assertFalse(): 期待结果为false
 *  assertNotNull(): 期待结果为非null
 *  assertArrayEquals(): 期待结果为数组并与期望数组每个元素的值均相等
 */
public class FactorialTest {


    @Test
    public void testFact() {
        assertEquals(1, Factorial.fact(1));
        assertEquals(2, Factorial.fact(2));
        assertEquals(6, Factorial.fact(3));
        assertEquals(3628800, Factorial.fact(10));
        assertEquals(2432902008176640000L, Factorial.fact(20));
    }


    @Test
    public void testFloat() {
        // 注意浮点数assertEquals()要指定误差值delta
        assertEquals(0.1, Math.abs(1 - 9 / 10.0), 0.0000001);
    }
}
