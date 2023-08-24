package cn.bravedawn.reflection.type.typevariable;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Map;

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
        TypeVariable typeVariable = (TypeVariable) type;

        System.out.println("字段类型：" + type.getClass());
        System.out.println("类型变量的上边界声明：" + Arrays.toString(typeVariable.getBounds()));
        System.out.println("类型变量的名称：" + typeVariable.getName());
        System.out.println("类型变量的对象类型：" + typeVariable.getGenericDeclaration());
        System.out.println("类型变量注解的边界：" + Arrays.toString(typeVariable.getAnnotatedBounds()));

    }


    static void testClass() {

    }

}
