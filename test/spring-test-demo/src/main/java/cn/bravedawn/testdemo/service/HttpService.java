package cn.bravedawn.testdemo.service;

import cn.bravedawn.testdemo.bean.HttpClient;
import cn.bravedawn.testdemo.bean.HttpsClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : depers
 * @program : spring-test-demo
 * @description:
 * @date : Created in 2021/9/24 15:57
 */
@Service
public class HttpService {

    @Autowired
    private HttpsClientImpl httpsClient;

    public int send() {
        int before = httpsClient.before();
        System.out.println("-----HttpService---before=" + before);
        return httpsClient.send();
    }

}
