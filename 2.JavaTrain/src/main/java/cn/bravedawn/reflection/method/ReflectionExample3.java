package cn.bravedawn.reflection.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample3 {

    /**
     * 调用方法
     */


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String s = "Hello world";
        String r = s.substring(6); // "world"
        System.out.println(r);


        // 获取String substring(int)方法，参数为int:
        Method m = String.class.getMethod("substring", int.class);
        // 在s对象上调用该方法并获取结果:
        String re = (String) m.invoke(s, 6);
        // 打印调用结果:
        System.out.println(re);
    }
}
