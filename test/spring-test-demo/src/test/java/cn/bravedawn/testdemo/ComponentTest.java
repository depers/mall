package cn.bravedawn.testdemo;

import cn.bravedawn.testdemo.bean.HttpClient;
import cn.bravedawn.testdemo.bean.HttpsClient;
import cn.bravedawn.testdemo.bean.HttpsClientImpl;
import cn.bravedawn.testdemo.service.HttpService;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class ComponentTest {


    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private HttpService httpService;

    @SpyBean
    private HttpClient httpClient;

//    @Before
//    public void init() {
//        MockitoAnnotations.openMocks(this);
//    }

    @Test
    public void testHttpsClient() {
        HttpsClientImpl httpsClient = Mockito.mock(HttpsClientImpl.class);

        Mockito.when(httpsClient.before()).thenCallRealMethod().thenReturn(3);
        ReflectionTestUtils.setField(httpService, HttpService.class, "httpsClient", httpsClient, HttpsClientImpl.class);

        int res = httpService.send();
        System.out.println("test res=" + res);
    }

    @Test
    public void testHttpsClientMockBean() {

        Mockito.when(httpClient.before()).thenReturn(3);

        int res = httpService.send();
        System.out.println("test res=" + res);
    }

    @Test
    public void testApplicationContext() {
        Arrays.stream(applicationContext.getBeanDefinitionNames())
                .forEach(bean -> System.out.println(bean));
    }
}
