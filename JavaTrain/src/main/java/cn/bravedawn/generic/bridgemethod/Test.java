package cn.bravedawn.generic.bridgemethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/17 11:29
 */
public class Test {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 使用java的多态
        Parent parent = new Child();
        System.out.println(parent.bridgeMethod("abc123")); // 调用的是实际的方法


        Class<? extends Parent> clz = parent.getClass();
        Method method = clz.getMethod("bridgeMethod", Object.class); // 获取桥接方法
        System.out.println(method.isBridge()); // true
        System.out.println(method.invoke(parent, "hello")); // 调用的是桥接方法

    }
}
