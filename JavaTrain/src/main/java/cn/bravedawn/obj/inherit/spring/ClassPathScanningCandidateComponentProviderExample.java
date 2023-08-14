package cn.bravedawn.obj.inherit.spring;

import cn.bravedawn.obj.inherit.protected_.Person;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ClassPathScanningCandidateComponentProviderExample {


    /**
     * 这个类主要演示了Spring-context提供的ClassPathScanningCandidateComponentProvider获取指定包下父类的所有子类
     */

    public static void main(String[] args) {
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AssignableTypeFilter(Person.class));
        Set<BeanDefinition> components = provider.findCandidateComponents("cn.bravedawn.obj.inherit.protected_");
        List<String> collect = components.stream().map(BeanDefinition::getBeanClassName).collect(Collectors.toList());
        System.out.println(collect);
    }
}
