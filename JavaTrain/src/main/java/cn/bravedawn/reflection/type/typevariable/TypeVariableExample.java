package cn.bravedawn.reflection.type.typevariable;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Map;


/**
 * TypeVariable 类型变量。例如List<T>中的T, Map<K,V>中的K和V，我们的测试类class TypeTest<T, V extends @Custom Number & Serializable>中的T和V。
 * 核心方法：
 *  1.getBounds()：返回此类型参数的上界列表，如果没有上界则放回Object. 例如 K extends @MyAnnotation(1) CharSequence & Serializable这个类型参数，有两个上界，CharSequence 和 Serializable
 *  2.getGenericDeclaration()：返回类型参数声明时的载体，例如 class TypeVariableExample<K extends @MyAnnotation(1) CharSequence & Serializable, V>，其中K的载体就是 TypeVariableExample
 *  3.getName()：返回源码中类型变量的名称
 *  4.getAnnotatedBounds()：Java 1.8加入 AnnotatedType: 如果这个这个泛型参数类型的上界用注解标记了，我们可以通过它拿到相应的注解
 */

public class TypeVariableExample<K extends @MyAnnotation(1) CharSequence & Serializable, V> {

    @MyAnnotation(2)
    K key;

    Map<K, V> map;



    public static void main(String[] args) throws NoSuchFieldException {
        TypeVariableExample<String, Integer> example = new TypeVariableExample<>();

        testField(example);
    }

    static void testField(TypeVariableExample typeVariableExample) throws NoSuchFieldException {
        Field f = typeVariableExample.getClass().getDeclaredField("key");
        Type type = f.getGenericType();
        boolean b = type instanceof TypeVariable;
        System.out.println("是否为类型变量：" + b);

        if (b) {
            TypeVariable typeVariable = (TypeVariable) type;
            System.out.println("字段类型：" + type.getClass());
            System.out.println("字段类型：" + typeVariable);
            System.out.println("返回此类型参数的上边界类型数组：" + Arrays.toString(typeVariable.getBounds()));
            System.out.println("类型参数的声明名称：" + typeVariable.getName());
            System.out.println("类型参数声明时的载体：" + typeVariable.getGenericDeclaration());
            System.out.println("类型参数上边界类型的注解：" + Arrays.asList(typeVariable.getAnnotatedBounds()[0].getAnnotations()));
        }
    }

}
