package cn.bravedawn.importannotation.method1;

import cn.bravedawn.importannotation.animal.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : depers
 * @program : spring-core
 * @description:
 * @date : Created in 2021/11/26 7:19
 */
@Configuration
public class DogConfig {

    @Bean
    Dog dog() {
        return new Dog();
    }
}