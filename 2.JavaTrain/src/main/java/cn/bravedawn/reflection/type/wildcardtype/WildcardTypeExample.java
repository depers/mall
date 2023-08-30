package cn.bravedawn.reflection.type.wildcardtype;


import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/**
 * WildcardType：通配符类型，即带有?的泛型参数, 例如 List<?>中的？，List<? extends Number>里的? extends Number 和List<? super Integer>的? super Integer 。
 *
 * 关键方法
 * 1. getUpperBounds()：获取上界
 * 2. getLowerBounds()：获取下界
 */


public class WildcardTypeExample {


    private Map<? super String, ? extends Number> map;


    public static void main(String[] args) throws NoSuchFieldException {

        Field mapField = WildcardTypeExample.class.getDeclaredField("map");
        Type type = mapField.getGenericType();

        System.out.println("是否为WildcardType类型：" + (type instanceof WildcardType));
        System.out.println("是否为ParameterizedType类型：" + (type instanceof ParameterizedType));
        Type[] actualTypes = ((ParameterizedType) type).getActualTypeArguments();
        System.out.println("获取<>中的类型定义：" + Arrays.asList(actualTypes));

        System.out.println("实际类型定义是否为WildcardType类型：" + (actualTypes[0] instanceof WildcardType));
        System.out.println("实际类型定义是否为WildcardType类型：" + (actualTypes[1] instanceof WildcardType));
        WildcardType firstWildcardType = (WildcardType) actualTypes[0];
        WildcardType secondWildcardType = (WildcardType) actualTypes[1];
        System.out.println("获取下界：" + Arrays.toString(firstWildcardType.getLowerBounds()));
        System.out.println("获取上界：" + Arrays.toString(secondWildcardType.getUpperBounds()));
    }
}
