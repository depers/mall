package cn.bravedawn.jackson;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author : depers
 * @program : jackson-demo
 * @description: 应用程序
 * @date : Created in 2021/11/6 13:42
 */
@SpringBootApplication
public class JacksonApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(JacksonApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
