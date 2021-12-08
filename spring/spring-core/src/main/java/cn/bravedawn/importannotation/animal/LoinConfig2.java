package cn.bravedawn.importannotation.animal;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author : depers
 * @program : spring-core
 * @description: @Import注解的使用方法三：ImportBeanDefinitionRegistrar方式
 * @date : Created in 2021/12/8 7:15
 */
public class LoinConfig2 implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //指定bean定义信息（包括bean的类型、作用域...）
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Loin.class);
        //注册一个bean指定bean名字（id）
        registry.registerBeanDefinition("loin2", rootBeanDefinition);
    }
}
