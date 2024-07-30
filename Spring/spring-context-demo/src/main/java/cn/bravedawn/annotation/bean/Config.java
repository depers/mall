package cn.bravedawn.annotation.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : depers
 * @program : spring-context-demo
 * @date : Created in 2024/7/30 10:16
 */

@Configuration
public class Config {

    @Bean
    public Fruit apple() {
        return new Fruit("apple", "red");
    }


    @Bean
    public Fruit banana() {
        return new Fruit("banana", "green");
    }

    @Bean
    public FruitService fruitService(@Qualifier("apple") Fruit fruit) {
        FruitService fruitService = new FruitService();
        fruitService.setFruit(fruit);
        fruitService.getFruitInfo();
        return fruitService;
    }
}
