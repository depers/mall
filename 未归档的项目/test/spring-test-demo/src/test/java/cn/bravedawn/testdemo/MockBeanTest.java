package cn.bravedawn.testdemo;

import cn.bravedawn.testdemo.bean.HttpClient;
import cn.bravedawn.testdemo.bean.PayClient;
import cn.bravedawn.testdemo.service.TestService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

/**
 * @author : depers
 * @program : spring-test-demo
 * @description: @SpyBean和@MockBean的测试
 * @date : Created in 2021/9/28 10:28
 */

@SpringBootTest
@DisplayName("@SpyBean和@MockBean的测试")
public class MockBeanTest {

    @MockBean
    private TestService mockBeanTestService;

    @MockBean
    private PayClient payClient;


    /**
     * autowiredTestService result = 1
     */
    @Test
    public void testMockBeanTestService() {
        Mockito.when(mockBeanTestService.execute()).thenReturn(1);

        int execute = mockBeanTestService.execute();
        System.out.println("autowiredTestService result = " + execute);
    }


    /**
     * --Method execute--
     * autowiredTestService result = 1
     */
    @Test
    public void testMockBeanTestService2() {
        Mockito.when(mockBeanTestService.execute()).thenCallRealMethod().thenReturn(1);
        int execute = mockBeanTestService.execute();
        System.out.println("autowiredTestService result = " + execute);
    }



    @Test
    public void testMockBeanPayClient() {
        int pay = payClient.pay();
        System.out.println("pay result = " + pay);
    }

}
