package cn.bravedawn.reflection.method;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class GetReturnTypeAndGetGenericReturnTypeExample {

    /**
     * getReturnType()和getGenericReturnType()的区别
     * 1.方法返回值的类型不同，getReturnType()返回的是Class，而getGenericReturnType()返回的是Type
     * 2.如果返回值是泛型，getReturnType()返回的是java.lang.Object，而getGenericReturnType()返回的是泛型类型T
     */



    static class Student {
        public String getName() {
            return "okk";
        }

        public <T> T getX() {
            return null;
        }
    }


    public static void main(String[] args) {
        Class<?> clazz = Student.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Class<?> returnType = method.getReturnType();
            Type genericReturnType = method.getGenericReturnType();

            System.out.println(returnType);
            System.out.println(genericReturnType);
        }
    }
}
