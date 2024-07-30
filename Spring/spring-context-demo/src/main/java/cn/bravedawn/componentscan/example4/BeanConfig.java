package cn.bravedawn.componentscan.example4;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author : depers
 * @program : spring-context-demo
 * @date : Created in 2024/7/22 15:47
 */

@ComponentScan(value = "cn.bravedawn.componentscan",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = CustomFilter.class)})
public class BeanConfig {
}
