package cn.bravedawn.testdemo;

import cn.bravedawn.testdemo.bean.HttpClient;
import cn.bravedawn.testdemo.bean.HttpsClientImpl;
import cn.bravedawn.testdemo.service.HttpService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;

/**
 * @author : depers
 * @program : spring-test-demo
 * @description:
 * @date : Created in 2021/9/24 15:18
 */
@SpringBootTest
@DisplayName("测试Component")
public class ComponentMockBeanTest {

    @Autowired
    private HttpService httpService;

    @MockBean
    private HttpClient httpClient;


    /**
     * 若出现继承
     * NoSuchBeanDefinitionException
     */
    @Test
    public void testHttpsClientMockBean() {

        Mockito.when(httpClient.before()).thenReturn(3);

        int res = httpService.send();
        System.out.println("test res=" + res);
    }

}
