package cn.bravedawn.orm;


import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

public class ReflectionExample {

    @CallerSensitive
    public void call() {
        Class<?> clazz = Reflection.getCallerClass();
        System.out.println("调用类：" + clazz); // class cn.bravedawn.orm.ReflectionExample2

    }
}
