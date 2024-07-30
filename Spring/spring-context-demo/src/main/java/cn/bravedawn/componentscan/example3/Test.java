package cn.bravedawn.componentscan.example3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : depers
 * @program : spring-context-demo
 * @date : Created in 2024/7/22 15:28
 *
 * @ComponentScan设置包名和包含过滤的情况下，只会取该包下包含这个注解的类才行
 * 注意：这里使用了useDefaultFilters，关闭默认对@Component @Repository, @Service, or @Controller的自动扫描
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(BeanConfig.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println("beanName: " + beanName);
        }
    }
}
