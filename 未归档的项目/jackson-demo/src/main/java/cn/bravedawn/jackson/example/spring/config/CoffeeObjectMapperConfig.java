package cn.bravedawn.jackson.example.spring.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import static cn.bravedawn.jackson.example.spring.config.CoffeeConstants.LOCAL_DATETIME_SERIALIZER;

/**
 * @author : depers
 * @program : jackson-demo
 * @description: 完全控制
 * @date : Created in 2021/11/6 16:07
 */
//@Configuration
public class CoffeeObjectMapperConfig {

    /**
     * 配置方法三：通过覆写原有的配置，来定义一个新的ObjectMapper
     */

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(LOCAL_DATETIME_SERIALIZER);
        return new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .registerModule(module);
    }
}
