package cn.bravedawn.jackson.example.spring.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import static cn.bravedawn.jackson.example.spring.config.CoffeeConstants.LOCAL_DATETIME_SERIALIZER;

/**
 * @author : depers
 * @program : jackson-demo
 * @description: MappingJackson2HttpMessageConverter
 * @date : Created in 2021/11/6 16:33
 */
@Configuration
public class CoffeeHttpConverterConfiguration {

    /**
     * 方法五：定义一个类型为MappingJackson2HttpMessageConverter的bean，spring boot将会自动使用它
     */

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder().serializers(LOCAL_DATETIME_SERIALIZER)
                .serializationInclusion(JsonInclude.Include.NON_NULL);
        return new MappingJackson2HttpMessageConverter(builder.build());
    }
}
