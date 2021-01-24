package cn.bravedawn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author : depers
 * @program : mall
 * @description: 启动类
 * @date : Created in 2021/1/24 16:21
 */

@SpringBootApplication
@ComponentScan(basePackages = {"cn.bravedawn", "org.n3r.idworker"})
@MapperScan("cn.bravedawn.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
