package cn.bravedawn.beanfactorydemo;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * @author : depers
 * @program : 1.spring4.x
 * @description:
 * @date : Created in 2023/9/11 20:41
 */
public class BeanFactoryExample {

    /**
     * IOC容器的示例
     */

    public static void main(String[] args) throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:cn/bravedawn/beanfactory/bean1.xml");
        System.out.println(res.getURL());

        // 购建bean容器
        DefaultListableBeanFactory factory =  new DefaultListableBeanFactory();
        // 使用Resource信息启动Ioc容器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        // 装配Spring的配置信息
        reader.loadBeanDefinitions(res);

        System.out.println("init BeanFactory");

        Car car = factory.getBean("car", Car.class);
        System.out.println("Car bean is ready for use");
        car.introduce();
    }
}
