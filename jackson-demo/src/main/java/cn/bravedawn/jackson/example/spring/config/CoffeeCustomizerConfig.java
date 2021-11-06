package cn.bravedawn.jackson.example.spring.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static cn.bravedawn.jackson.example.spring.config.CoffeeConstants.LOCAL_DATETIME_SERIALIZER;

/**
 * @author : depers
 * @program : jackson-demo
 * @description: ackson2ObjectMapperBuilderCustomizer
 * @date : Created in 2021/11/6 16:00
 */
//@Configuration
public class CoffeeCustomizerConfig {

    /**
     * 配置方法二：这个配置类的效果和CoffeeRegisterModuleConfig一样
     */

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> builder.serializationInclusion(JsonInclude.Include.NON_NULL)
                .serializers(LOCAL_DATETIME_SERIALIZER);
    }
}
