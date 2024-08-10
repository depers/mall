package cn.bravedawn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : depers
 * @program : mybatis-batch-insert
 * @date : Created in 2024/8/9 21:24
 */

@SpringBootApplication
@MapperScan(basePackages = "cn.bravedawn.dao")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
