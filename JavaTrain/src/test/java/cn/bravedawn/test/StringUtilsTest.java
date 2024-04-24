package cn.bravedawn.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2024-01-11 11:22
 *
 */
public class StringUtilsTest {

    /**
     * @MethodSource注解，它允许我们编写一个同名的静态方法来提供测试参数
     * @CsvSource注解，它的每一个字符串表示一行，一行包含的若干参数用,分隔
     * @CsvFileSource注解，把测试数据提到一个独立的CSV文件中
     */




    @ParameterizedTest
    @MethodSource
    void testCapitalize(String input, String result) {
        assertEquals(result, StringUtils.capitalize(input));
    }

    static List<Arguments> testCapitalize() {
        return List.of( // arguments:
                Arguments.of("abc", "Abc"), //
                Arguments.of("APPLE", "Apple"), //
                Arguments.of("gooD", "Good"));
    }


    @ParameterizedTest
    @CsvSource({ "abc, Abc", "APPLE, Apple", "gooD, Good" })
    void testCapitalize2(String input, String result) {
        assertEquals(result, StringUtils.capitalize(input));
    }



    @ParameterizedTest
    @CsvFileSource(resources = { "/test-capitalize.csv" })
    void testCapitalizeUsingCsvFile(String input, String result) {
        assertEquals(result, StringUtils.capitalize(input));
    }
}
