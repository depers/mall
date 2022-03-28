package cn.bravedawn.reflection.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample6 {

    /**
     * 通过反射调用方法时，仍然遵循多态原则。子类复写了父类的方法，通过反射应该如何调用
     *
     * Person p = new Student();
     * p.hello();
     *
     */


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 获取Person的hello方法:
        Method h = Person.class.getMethod("hello");
        // 对Student实例调用hello方法:
        h.invoke(new Stripling());

    }
}
