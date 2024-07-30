package cn.bravedawn.componentscan.example3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author : depers
 * @program : spring-context-demo
 * @date : Created in 2024/7/22 15:28
 */

@ComponentScan(value = "cn.bravedawn.componentscan.controller",
    useDefaultFilters = false,
    includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)
    })
public class BeanConfig {
}
