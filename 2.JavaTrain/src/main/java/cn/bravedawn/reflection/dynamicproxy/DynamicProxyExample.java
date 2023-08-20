package cn.bravedawn.reflection.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyExample {

    /**
     * 动态代理
     */

    public static void main(String[] args) {
        // 1. 定义一个InvocationHandler实例，它负责实现接口的方法调用；
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };

        // 2. 通过Proxy.newProxyInstance()创建interface实例
        // 2.1 使用的ClassLoader，通常就是接口类的ClassLoader
        // 2.2 需要实现的接口数组，至少需要传入一个接口进去
        // 2.3 用来处理接口方法调用的InvocationHandler实例
        // 2.4 将返回的Object强制转型为接口
        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),
                new Class[]{Hello.class},
                handler);

        hello.morning("fengxiao");
    }
}
