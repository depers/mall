package cn.bravedawn;

import org.junit.jupiter.api.*;

/**
 * @author : depers
 * @program : junit
 * @description: 常用注解的基本使用
 * @date : Created in 2021/12/8 21:38
 */
@DisplayName("AppTest-测试")
public class AppTest {

    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll executed");
    }

    @BeforeEach
    void setupThis() {
        System.out.println("@BeforeEach executed");
    }


    @Tag("DEV")
    @Test
    @DisplayName("第一个测试方法")
    void testCalcOne() {
        System.out.println("==test one executed==");
        Assertions.assertEquals(4, Calculator.add(2, 2));
    }


    @Tag("PROD")
    @Test
    @Disabled
    @DisplayName("第二个测试方法")
    void testCalcTwo() {
        System.out.println("==test two executed==");
        Assertions.assertEquals(6, Calculator.add(2, 4));
    }

    @AfterEach
    void tearThis() {
        System.out.println("@AfterEach executed");
    }


    @AfterAll
    static void tear() {
        System.out.println("AfterAll executed");
    }



}
