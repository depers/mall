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


    /**
     * GenericArrayType的关键方法
     * getGenericComponentType()：获取数组前面的类型，也就是[]前面的类型
     */

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
