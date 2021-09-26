package cn.bravedawn.testdemo;

import cn.bravedawn.testdemo.bean.HttpClient;
import cn.bravedawn.testdemo.bean.HttpsClient;
import cn.bravedawn.testdemo.bean.HttpsClientImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

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

    @MockBean
    private HttpsClient httpsClient;

    @Test
    public void testHttpsClient() {
        httpsClient.send();
    }

    @Test
    public void testApplicationContext() {
        Arrays.stream(applicationContext.getBeanDefinitionNames())
                .forEach(bean -> System.out.println(bean));
    }
}
