package cn.bravedawn;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

/**
 * @author : depers
 * @program : junit
 * @description: Assumtions测试
 * @date : Created in 2021/12/8 22:09
 */
public class AssumptionsTest {

    private static String message() {
        return "Test execution failed";
    }


    @Test
    void testOneDev() {
        System.setProperty("ENV", "DEV");
        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")), AssumptionsTest::message);
    }


    @Test
    void testOnProd() {
        System.setProperty("ENV", "PROD");
        Assumptions.assumeFalse("DEV".equals(System.getProperty("ENV")));
    }



}
