package cn.bravedawn.componentscan.example2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : depers
 * @program : spring-context-demo
 * @date : Created in 2024/7/22 15:28
 *
 * @ComponentScan设置包名的情况，只会扫描@Component、@Service等注解的类
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
