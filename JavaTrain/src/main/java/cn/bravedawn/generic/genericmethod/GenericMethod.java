package cn.bravedawn.generic.genericmethod;

import java.lang.reflect.InvocationTargetException;

public class GenericMethod {

    /**
     * 泛型方法
     *
     * 说明：
     *      1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法
     *      2）第二个 T 声明了返回值的类型
     *      3）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
     *
     */

    public <T> T genericMethod(Class<T> tClass) throws Exception {
        T instance = tClass.getDeclaredConstructor().newInstance();
        return instance;
    }


    /**
     * 泛型方法和可变参数
     */
    public <T> void printMsg(T... args) {
        for (T t : args) {
            System.out.println("泛型测试：t=" + t);
        }
    }



}
