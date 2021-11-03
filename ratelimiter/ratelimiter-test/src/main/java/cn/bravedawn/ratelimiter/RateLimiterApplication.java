package cn.bravedawn.ratelimiter;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author : depers
 * @program : ratelimiter
 * @description: 启动类
 * @date : Created in 2021/11/3 21:45
 */
@SpringBootApplication
public class RateLimiterApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RateLimiterApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
