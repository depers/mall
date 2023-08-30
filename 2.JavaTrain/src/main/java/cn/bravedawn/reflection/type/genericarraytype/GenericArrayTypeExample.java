package cn.bravedawn.reflection.type.genericarraytype;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * GenericArrayType 泛型数组类型，用来作为数组的泛型声明类型。例如List<T>[] ltArray， T[] tArray两个数组，其中List<T>[]和T[]就是GenericArrayType类型。
 *
 * 关键方法：
 * 1.getGenericComponentType()：获取泛型类型数组的声明类型，即获取数组方括号 [] 前面的部分
 */

public class GenericArrayTypeExample<T> {

    private T[] tArray;

    private List<T>[] tListArray;


    public static void main(String[] args) throws NoSuchFieldException {
        Field tArrayField = GenericArrayTypeExample.class.getDeclaredField("tArray");
        testField(tArrayField);
        System.out.println("----------------------------");

        Field tListArrayField = GenericArrayTypeExample.class.getDeclaredField("tListArray");
        testField(tListArrayField);
    }

    static void testField(Field field) {
        Type type = field.getGenericType();

        System.out.println("数组参数的类型：" + type);
        System.out.println("是否为GenericArrayType类型：" + (type instanceof GenericArrayType));
        System.out.println("泛型类型数组声明的类型：" + ((GenericArrayType) type).getGenericComponentType());
    }
}
