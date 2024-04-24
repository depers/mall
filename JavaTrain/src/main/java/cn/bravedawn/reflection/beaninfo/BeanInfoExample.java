package cn.bravedawn.reflection.beaninfo;

import java.beans.*;

/**
 * @Description : BeanInfo类的用法
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-10-08 13:49
 */
public class BeanInfoExample {

    /**
     * java.beans.BeanInfo是一个接口，它有几个默认的实现类，我们一般默认生成的BeanInfo对象其实是GenericBeanInfo类的实例。
     * 简而言之，BeanInfo对象能提供关于JavaBean的方法，属性，事件以及其他特征的明确信息。
     */


    public static void main(String[] args) throws IntrospectionException {
        // 不内省父类的信息,第二个参数stopClass代表从stopClass开始往上的父类不再内省
        BeanInfo info = Introspector.getBeanInfo(Student.class, Object.class);
        // 会内省起所有父类的信息
        BeanInfo info2 = Introspector.getBeanInfo(Student.class);

        printInfo(info);
        System.out.println("--------------");
        printInfo(info2);

    }


    private static void printInfo(BeanInfo beanInfo) {
        // 获得对象描述器
        BeanDescriptor beanDescriptor = beanInfo.getBeanDescriptor();
        System.out.println(beanDescriptor);

        // 获得所有属性描述器
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        System.out.println("获得所有属性描述器：");
        for (PropertyDescriptor item : propertyDescriptors) {
            System.out.println(item);
        }
        System.out.println();

        // 获得所有方法描述器
        MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
        System.out.println("获得所有方法描述器：");
        for (MethodDescriptor item : methodDescriptors) {
            System.out.println(item);
        }
        System.out.println();

        // 获得所有事件描述器
        EventSetDescriptor[] eventSetDescriptors = beanInfo.getEventSetDescriptors();
        System.out.println("获得所有事件描述器：");
        for (EventSetDescriptor item : eventSetDescriptors) {
            System.out.println(item);
        }
        System.out.println();
    }
}
