package cn.bravedawn.springhikaricp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author : fengx9
 * @Project : hikaricp-demo
 * @Date : Created in 2023-11-28 09:39
 */

@SpringBootApplication
public class SpringHikariCpApplication {


    public static void main(String[] args) {
        H2Starter.startH2Server();
        SpringApplication.run(SpringHikariCpApplication.class, args);
    }


}
