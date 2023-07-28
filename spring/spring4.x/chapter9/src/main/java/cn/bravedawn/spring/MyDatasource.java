package cn.bravedawn.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : chapter9
 * @description:
 * @date : Created in 2023/7/28 20:38
 */

@Component
public class MyDatasource {

    @Value("#{properties['driverClassName']}")
    private String driverClassName;

    @Value("${url}")
    private String url;

    @Value("#{properties['userName']}")
    private String userName;

    @Value("#{properties['password']}")
    private String password;

    @Override
    public String toString() {
        return "MyDatasource{" +
                "driverClassName='" + driverClassName + '\'' +
                ", url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
