package cn.bravedawn.testdemo;

import cn.bravedawn.testdemo.service.TestService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
public class SpyBeanTest {

    @SpyBean
    private TestService spyBeanTestService;



    /**
     * --Method execute--
     * --Method doSomething--
     * autowiredTestService result = 1
     */
    @Test
    public void testSpyBeanTestService() {
        Mockito.when(spyBeanTestService.execute()).thenReturn(1);
        int execute = spyBeanTestService.execute();
        System.out.println("autowiredTestService result = " + execute);
    }




}
