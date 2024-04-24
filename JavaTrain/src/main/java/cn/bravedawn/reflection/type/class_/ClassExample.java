package cn.bravedawn.reflection.type.class_;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class ClassExample<T> {


    interface Example<T> {

    }

    // 该类的变量
    private ClassExample classExample;

    // 泛型参数具体化的变量
    private ClassExample<String> classExample2;

    // 泛型参数没有具体化的变量
    private ClassExample<T> classExample3;

    // 测试泛型参数具体化的List变量
    private List<String> list;

    // 测试泛型参数没有具体化的List变量
    private List<T> list2;

    // 自己实现一个接口的变量，并将其泛型参数具体化
    private Example<String> example;

    // 自己实现一个接口的变量，其泛型参数不做具体化
    private Example<T> example2;

    public static void main(String[] args) throws NoSuchFieldException {
        System.out.println("参数：classExample--------------------------------");
        Field classField = ClassExample.class.getDeclaredField("classExample");
        testField(classField);

        System.out.println("参数：classExample--------------------------------");
        Field classField2 = ClassExample.class.getDeclaredField("classExample");
        testField(classField2);

        System.out.println("参数：classExample3--------------------------------");
        Field classField3 = ClassExample.class.getDeclaredField("classExample3");
        testField(classField3);

        System.out.println("参数：list--------------------------------");
        Field list = ClassExample.class.getDeclaredField("list");
        testField(list);

        System.out.println("参数：list2--------------------------------");
        Field list2 = ClassExample.class.getDeclaredField("list2");
        testField(list2);

        System.out.println("参数：example--------------------------------");
        Field example = ClassExample.class.getDeclaredField("example");
        testField(example);

        System.out.println("参数：example2--------------------------------");
        Field example2 = ClassExample.class.getDeclaredField("example2");
        testField(example2);

    }


    static void testField(Field field) {
        Type type = field.getGenericType();
        System.out.println("字段类型：" + type);
        System.out.println("是否为Class类型：" + (type instanceof Class));
        System.out.println("是否为ParameterizedType类型：" + (type instanceof ParameterizedType));
        System.out.println();
    }
}
