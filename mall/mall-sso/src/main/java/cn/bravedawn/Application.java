package cn.bravedawn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author 冯晓
 * @Date 2019/12/26 20:12
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@MapperScan("cn.bravedawn.mapper")
@ComponentScan(basePackages = {"cn.bravedawn", "org.n3r.idworker"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
