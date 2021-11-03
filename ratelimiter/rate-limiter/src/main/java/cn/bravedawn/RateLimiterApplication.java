package cn.bravedawn;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author : depers
 * @program : ratelimiter
 * @description: 启动类
 * @date : Created in 2021/10/28 6:42
 */

@SpringBootApplication
public class RateLimiterApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RateLimiterApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
