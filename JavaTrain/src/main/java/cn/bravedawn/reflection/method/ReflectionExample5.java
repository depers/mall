package cn.bravedawn.reflection.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample5 {

    /**
     * 调用非public方法
     * @param args
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        People people = new People();

        Method m = people.getClass().getDeclaredMethod("setName", String.class);
        m.setAccessible(true);
        m.invoke(people, "Bob");
        System.out.println(people.name);


    }
}
