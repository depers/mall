package cn.bravedawn.applicationcontext;

import cn.bravedawn.beanfactorydemo.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

/**
 * @author : depers
 * @program : 1.spring4.x
 * @description:
 * @date : Created in 2023/9/12 20:19
 */
public class GroovyApplicationContextExample {

    /**
     * 这个类主要演示了使用 GenericGroovyApplicationContext启动Spring容器的示例
     */


    public static void main(String[] args) {
        ApplicationContext ctx =
                new GenericGroovyApplicationContext("classpath:cn/bravedawn/applicationcontext/beans.groovy");
        Car car = (Car) ctx.getBean("car");
        car.introduce();
    }
}
