package cn.bravedawn.applicationbeanfactorydemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * @author : depers
 * @program : spring-demo
 * @description:
 * @date : Created in 2023/5/21 11:13
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {


    // 接口方法：在实例化Bean前调用
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        // 仅对容器中的Car Bean处理
        if ("car".equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation");
        }

        return null;
    }


    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        // 仅对容器中的Car Bean处理
        if ("car".equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation");
        }

        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcessor.postProcessPropertyValues");
        }
        return pvs;
    }
}
