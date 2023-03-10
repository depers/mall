package cn.bravedawn.reflection.method;

import java.lang.reflect.Method;
import java.util.Arrays;

public class GetMethodsExample {

    /**
     * 获取一个类的方法
     * getDeclaredMethods()
     * getMethods()
     */


    public static void main(String[] args) {
        Class clazz = Student.class;
        // 获取当前类的方法，但不包括继承的父类和接口的方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(method -> System.out.println(method.getName()));
        System.out.println("--------------------");

        Method[] methods = clazz.getMethods();
        // 获取当前类的接口，包括父类和接口的方法
        Arrays.stream(methods).forEach(method -> System.out.println(method.getName()));
    }
}
