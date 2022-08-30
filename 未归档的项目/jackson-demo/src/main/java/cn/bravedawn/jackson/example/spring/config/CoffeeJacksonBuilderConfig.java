package cn.bravedawn.jackson.example.spring.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import static cn.bravedawn.jackson.example.spring.config.CoffeeConstants.LOCAL_DATETIME_SERIALIZER;

/**
 * @author : depers
 * @program : jackson-demo
 * @description: Jackson2ObjectMapperBuilder
 * @date : Created in 2021/11/6 16:14
 */
//@Configuration
public class CoffeeJacksonBuilderConfig {

    /**
     * 配置方法四：Spring Boot在构建objectapper时实际上默认使用此构建器，并将自动选择已定义的构建器
     */

    @Bean
    @Primary
    public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
        return new Jackson2ObjectMapperBuilder()
                .serializers(LOCAL_DATETIME_SERIALIZER)
                .serializationInclusion(JsonInclude.Include.NON_NULL);
    }
}
