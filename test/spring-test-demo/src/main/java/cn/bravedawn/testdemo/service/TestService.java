package cn.bravedawn.testdemo.service;

import cn.bravedawn.testdemo.bean.PayClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : depers
 * @program : spring-test-demo
 * @description: testService
 * @date : Created in 2021/9/28 10:30
 */

@Service
public class TestService {

    @Autowired
    private PayClient payClient;

    public int doSomething() {
        System.out.println("--Method doSomething--");
        return 1;
    }

    public int execute() {
        System.out.println("--Method execute--");
        return doSomething() + 1;
    }

    public void payment() {
        payClient.pay();
    }
}
