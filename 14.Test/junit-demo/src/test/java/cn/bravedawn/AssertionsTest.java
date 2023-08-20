package cn.bravedawn;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : depers
 * @program : junit-demo
 * @description:
 * @date : Created in 2023/5/5 10:27
 */
public class AssertionsTest {


    /**
     * 断言，下面演示的断言可以使用Lambda表达式
     */


    @Test
    void lambdaExpressions() {
        List numbers = Arrays.asList(1, 2, 3);
        assertTrue(numbers.stream()
                .mapToInt(i -> Integer.parseInt(String.valueOf(i)))
                .sum() > 5, () -> "Sum should be greater than 5");
    }


    @Test
    void groupAssertions() {
        int[] numbers = {0, 1, 2, 3, 4};
        assertAll("numbers",
                () -> assertEquals(numbers[0], 1),
                () -> assertEquals(numbers[3], 3),
                () -> assertEquals(numbers[4], 1)
        );
    }
}
