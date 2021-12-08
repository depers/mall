package cn.bravedawn.testdemo.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : spring-test-demo
 * @description:
 * @date : Created in 2021/9/24 15:16
 */
@Component
@Primary
public class HttpsClientImpl extends HttpsClient{


    @Override
    public int before() {
        System.out.println("------------------我是HttpsClientImpl");
        return 2;
    }
}
