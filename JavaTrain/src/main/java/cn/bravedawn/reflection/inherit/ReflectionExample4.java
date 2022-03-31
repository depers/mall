package cn.bravedawn.reflection.inherit;

import java.io.Serializable;

public class ReflectionExample4 {

    /**
     * 继承关系
     * 1.当我们判断一个实例是否是某个类型时，正常情况下，使用instanceof操作符;
     * 2.如果是两个Class实例，要判断一个向上转型是否成立，可以调用isAssignableFrom();
     */


    public static void main(String[] args) {
        Object n = Integer.valueOf(123);
        boolean isDouble = n instanceof Double;
        System.out.println(isDouble); // false
        boolean isInteger = n instanceof Integer;
        System.out.println(isInteger); // true
        boolean isNumber = n instanceof Number;
        System.out.println(isNumber); // true
        boolean isSerializable = n instanceof Serializable;
        System.out.println(isSerializable); // true


        System.out.println(Integer.class.isAssignableFrom(Integer.class)); // true
        System.out.println(Number.class.isAssignableFrom(Integer.class)); // true
        System.out.println(Object.class.isAssignableFrom(Integer.class)); // true
        System.out.println(Integer.class.isAssignableFrom(Number.class)); // false

    }
}
