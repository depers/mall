package cn.bravedawn.reflection.inherit;

import java.io.Closeable;
import java.util.Arrays;

public class ReflectionExample3 {

    /**
     * 1.对所有interface的Class调用getSuperclass()返回的是null
     * 2.获取接口的父接口要用getInterfaces()
     */


    public static void main(String[] args) {

        Class cls = Comparable.class;
        System.out.println(cls.getSuperclass()); // null


        Class<Closeable> closeableClass = Closeable.class;
        System.out.println(Arrays.toString(closeableClass.getInterfaces()));

    }
}
