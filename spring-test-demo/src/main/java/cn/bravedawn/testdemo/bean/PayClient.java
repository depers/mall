package cn.bravedawn.testdemo.bean;

import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : spring-test-demo
 * @description:
 * @date : Created in 2021/9/28 10:45
 */
@Component
public class PayClient implements HttpClient{


    public int pay() {
        System.out.println("--pay--");
        return 0;
    }

    @Override
    public int before() {
        return 0;
    }
}
