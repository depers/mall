package cn.bravedawn.componentscan.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : depers
 * @program : spring-context-demo
 * @date : Created in 2024/7/22 15:28
 *
 * 直接使用@ComponentScan注入到Spring容器到的bean
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
