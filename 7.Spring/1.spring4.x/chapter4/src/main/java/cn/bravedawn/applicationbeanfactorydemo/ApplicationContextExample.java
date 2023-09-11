package cn.bravedawn.applicationbeanfactorydemo;

import cn.bravedawn.beanfactorydemo.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : depers
 * @program : 1.spring4.x
 * @description:
 * @date : Created in 2023/9/11 21:06
 */
public class ApplicationContextExample {

    /**
     * 使用基于注解类的配置提供的AnnotationConfigApplicationContext启动容器的示例
     */


    public static void main(String[] args) {
        // 通过一个带有@Configuration的POJO装载Bean配置
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        Car car = ctx.getBean("car", Car.class);
        car.introduce();
    }
}
