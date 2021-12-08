package cn.bravedawn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

/**
 * @author : depers
 * @program : junit
 * @description: Assertions example
 * @date : Created in 2021/12/8 22:00
 */
public class AssertionsTest {


    @Test
    void testCase() {
        Assertions.assertNotEquals(3, Calculator.add(2, 2));

        // Assertions.assertNotEquals(4, Calculator.add(2, 2), "Calculator.add(2, 2) test failed");

        Supplier<String> messageSupplier = () -> "Calculator.add(2, 2) test failed";
        Assertions.assertNotEquals(4, Calculator.add(2, 2), messageSupplier);
    }
}
