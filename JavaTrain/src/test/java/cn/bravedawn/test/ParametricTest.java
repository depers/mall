package cn.bravedawn.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2024-01-11 11:19
 *
 * 参数化测试
 */
public class ParametricTest {

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 5, 100 })
    void testAbs(int x) {
        assertEquals(x, Math.abs(x));
    }


    @ParameterizedTest
    @ValueSource(ints = { -1, -5, -100 })
    void testAbsNegative(int x) {
        assertEquals(-x, Math.abs(x));
    }
}
