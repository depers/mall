package cn.bravedawn.annotations.autowried;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : depers
 * @program : spring-beans-demo
 * @date : Created in 2024/7/30 09:22
 */
@Configuration
public class Config {


    @Bean
    public Fruit apple() {
        return new Fruit("apple", "red");
    }

    @Bean
    public Fruit banana() {
        return new Fruit("banana", "yellow");
    }
}
