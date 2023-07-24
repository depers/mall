package cn.bravedawn.applicationbeanfactorydemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author : depers
 * @program : chapter4
 * @description:
 * @date : Created in 2023/7/24 15:15
 */
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("调用【MyBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry】添加新的bus Bean定义");
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(Bus.class);
        registry.registerBeanDefinition("bus", beanDefinition);

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("调用【MyBeanDefinitionRegistryPostProcessor.postProcessBeanFactory】对bus Bean的属性进行修改");
        BeanDefinition bus = beanFactory.getBeanDefinition("bus");
        bus.getPropertyValues().add("name", "324");
        bus.getPropertyValues().add("color", "蓝色");
        bus.getPropertyValues().add("speed", "100km/h");

    }
}
