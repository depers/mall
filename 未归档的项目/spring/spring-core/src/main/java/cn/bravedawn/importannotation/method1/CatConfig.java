package cn.bravedawn.importannotation.method1;

import cn.bravedawn.importannotation.animal.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : depers
 * @program : spring-core
 * @description:
 * @date : Created in 2021/11/26 7:19
 */
@Configuration
public class CatConfig {

    @Bean
    Cat cat() {
        return new Cat();
    }
}
