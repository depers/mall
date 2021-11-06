package cn.bravedawn.jackson.example.spring.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import static cn.bravedawn.jackson.example.spring.config.CoffeeConstants.LOCAL_DATETIME_SERIALIZER;

/**
 * @author : depers
 * @program : jackson-demo
 * @description: Coffee配置
 * @date : Created in 2021/11/6 14:24
 */
//@Configuration
@PropertySource("classpath:coffee.properties")
public class CoffeeRegisterModuleConfig {

    /**
     * 配置方法一：配置javaTimeModule
     */

    @Bean
    public Module javaTimeModule() {
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(LOCAL_DATETIME_SERIALIZER);
        return module;
    }

}
