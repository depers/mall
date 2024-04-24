package cn.bravedawn.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2024-01-10 14:38
 *
 * 条件测试，在满足某项条件的情况下才执行测试代码
 * @Disabled： 不执行
 * @EnabledOnOs：在不同的操作系统上执行不同的测试代码
 * @DisabledOnJre(JRE.JAVA_8)：只能在Java 9或更高版本执行的测试，可以加上
 * @EnabledIfSystemProperty：只能在64位操作系统上执行的测试，可以用判断
 * @EnabledIfEnvironmentVariable：环境变量DEBUG=true才能执行的测试
 */
public class ConfigTest {

    private static Config config;

    @BeforeAll
    public static void setUp() {
        config = new Config();
    }

    @Test
    @Disabled
    public void testBug() {

    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testWindows() {
        assertEquals("C:\\test.ini", config.getConfigFile("test.ini"));
    }

    @Test
    @EnabledOnOs({ OS.LINUX, OS.MAC })
    void testLinuxAndMac() {
        assertEquals("/usr/local/test.cfg", config.getConfigFile("test.cfg"));
    }

    @Test
    @DisabledOnJre(JRE.JAVA_8)
    void testOnJava9OrAbove() {
        // TODO: this test is disabled on java 8
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void testOnlyOn64bitSystem() {
        // TODO: this test is only run on 64 bit system
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "DEBUG", matches = "true")
    void testOnlyOnDebugMode() {
        // TODO: this test is only run on DEBUG=true
    }

}
