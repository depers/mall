package cn.bravedawn.testdemo;

import cn.bravedawn.testdemo.service.TestService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

/**
 * @author : depers
 * @program : spring-test-demo
 * @description: @SpyBean和@MockBean的测试
 * @date : Created in 2021/9/28 10:28
 */

@SpringBootTest
@DisplayName("@SpyBean和@MockBean的测试")
public class AutowiredBeanTest {


    @Autowired
    private TestService autowiredTestService;


    /**
     * 执行过程：
     *  --Method execute--
     *  --Method doSomething--
     *  autowiredTestService result = 2
     */
    @Test
    public void testAutowiredTestService() {
        int execute = autowiredTestService.execute();
        System.out.println("autowiredTestService result = " + execute);
    }





}
