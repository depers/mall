package cn.bravedawn.testdemo;

import cn.bravedawn.testdemo.bean.HttpClient;
import cn.bravedawn.testdemo.bean.HttpsClientImpl;
import cn.bravedawn.testdemo.bean.PayClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * @author : depers
 * @program : spring-test-demo
 * @description:
 * @date : Created in 2021/9/28 10:59
 */
@SpringBootTest
public class MockPayClient {


    @MockBean
    private HttpClient HttpClient;


    /**
     * NoSuchBeanDefinitionException
     */
    @Test
    public void testMockPayClient() {
        int send = HttpClient.send();
        System.out.println("result = " + send);
    }
}
