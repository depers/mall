package cn.bravedawn.reflection.type;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/**
 * @author : depers
 * @program : mybatis
 * @description: GenericArrayType类型
 * @date : Created in 2021/4/28 13:27
 */
public class GenericArrayTypeExample<T> {

    List<T>[] parameterizedArray;

    T[] typeVariableArray;


    public static void main(String[] args) {
        Arrays.stream(GenericArrayTypeExample.class.getDeclaredFields()).forEach(field -> {
            Type type = field.getGenericType();
            if (type instanceof GenericArrayType) {
                System.out.println(field.getName() + " type is: GenericArrayType");
                System.out.println(((GenericArrayType) type).getGenericComponentType());
                System.out.println("---------------------------");
            }

        });
    }
}
