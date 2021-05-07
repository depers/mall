package cn.bravedawn.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.bravedawn.demo.dao")
public class DistributeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributeDemoApplication.class, args);
    }

}
