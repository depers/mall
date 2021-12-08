package cn.bravedawn.testdemo.bean;

import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : spring-test-demo
 * @description:
 * @date : Created in 2021/9/24 15:16
 */
@Component
public class HttpsClient implements HttpClient{

    @Override
    public int before() {
        System.out.println("------------------我是HttpsClient");
        return 1;
    }
}
