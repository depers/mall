package cn.bravedawn.reflection.method;

import java.lang.reflect.Method;
import java.util.Arrays;

public class GetMethodsExample2 {

    /**
     * 获取一个接口的方法，和获取类的方法是一样的
     */

    public static void main(String[] args) {
        Class<?> clazz = ReadBookInterface.class;


        Method[] declaredMethods = clazz.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(method -> System.out.println(method.getName()));
        System.out.println("-----------------------");

        Method[] methods = clazz.getMethods();
        Arrays.stream(methods).forEach(method -> System.out.println(method.getName()));
    }
}
