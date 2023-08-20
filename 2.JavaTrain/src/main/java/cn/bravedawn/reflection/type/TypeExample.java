package cn.bravedawn.reflection.type;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author : depers
 * @program : mybatis
 * @description: ParameterizedType应用
 * @date : Created in 2021/3/26 7:18
 */
public class TypeExample<T>{

    /**
     * ParameterizedType，参数化类型，即泛型；例如：List<T>、Map<K,V>等带有参数化的对象;
     */

    private List<T> list = null;

    private Set<T> set = null;

    private T value = null;


    public T getValue(){
        return value;
    }

    public List<T> getList(){
        return list;
    }

    public T[] getArray(){
        return (T[]) list.toArray();
    }

    public int getInt(){
        return 1;
    }

    public String getString(){
        return "1";
    }



    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        TypeExample<String> typeExample = new TypeExample<>();

        Field fieldList = typeExample.getClass().getDeclaredField("list");

        Type typeList = fieldList.getGenericType();

        System.out.println(typeList.getClass().getName());  // sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl


        Method[] methods = typeExample.getClass().getDeclaredMethods();

        Arrays.stream(methods).forEach(m -> {
            Type type = m.getGenericReturnType();
            if (type instanceof TypeVariable) {
                System.out.println("method: " + m.getName() + " type=" + type + " is 【TypeVariable】");
            } else if (type instanceof ParameterizedType) {
                System.out.println("method: " + m.getName() + " type=" + type + " is 【ParameterizedType】");
            } else if (type instanceof GenericArrayType) {
                System.out.println("method: " + m.getName() + " type=" + type + " is 【GenericArrayType】");
            } else if (type instanceof Class) {
                System.out.println("method: " + m.getName() + " type=" + type + " is 【class】");
            }
        });


    }
}
