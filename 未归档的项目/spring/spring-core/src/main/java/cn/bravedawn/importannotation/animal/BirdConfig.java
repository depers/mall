package cn.bravedawn.importannotation.animal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : depers
 * @program : spring-core
 * @description: Bird配置
 * @date : Created in 2021/11/26 7:17
 */
@Configuration
public class BirdConfig {

    @Bean
    Bird bird() {
        return new Bird();
    }
}
