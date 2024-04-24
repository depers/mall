package cn.bravedawn.reflection.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorExample {

    /**
     * 通过反射中的Constructor创建一个实例
     */

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        // 获取构造方法Integer(int):
        Constructor cons = Integer.class.getConstructor(int.class);
        // 调用构造方法:
        Integer n1 = (Integer) cons.newInstance(123);
        System.out.println(n1);

        Constructor cons2 = Integer.class.getConstructor(String.class);
        Integer n2 = (Integer) cons2.newInstance("123");
        System.out.println(n2);
    }
}
