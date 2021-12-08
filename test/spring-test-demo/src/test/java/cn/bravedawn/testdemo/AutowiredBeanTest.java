package cn.bravedawn.testdemo;

import cn.bravedawn.testdemo.bean.HttpClient;
import cn.bravedawn.testdemo.bean.HttpsClient;
import cn.bravedawn.testdemo.bean.HttpsClientImpl;
import cn.bravedawn.testdemo.service.TestService;
import cn.bravedawn.testdemo.utils.SpringContextUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.ApplicationContext;

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

    @Autowired
    private SpringContextUtils springContextUtils;

    @Autowired
    @Qualifier("httpsClient")
    private HttpsClient httpsClient;

    @Autowired
    @Qualifier("httpsClientImpl")
    private HttpsClientImpl httpsClientImpl;


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


    @Test
    public void getBeanFromContext() {
        HttpClient httpsClientImpl = (HttpsClientImpl) springContextUtils.getContext().getBean("httpsClientImpl");
        HttpClient httpsClient = (HttpsClient) springContextUtils.getContext().getBean("httpsClient");

        httpsClientImpl.before();
        httpsClient.before();
    }

    @Test
    public void getBeanAutowired() {
        httpsClientImpl.before();
        httpsClient.before();
    }





}
