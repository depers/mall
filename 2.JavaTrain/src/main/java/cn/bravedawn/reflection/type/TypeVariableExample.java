package cn.bravedawn.reflection.type;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.List;

/**
 * @author : depers
 * @program : mybatis
 * @description: TypeVariable测试类
 * @date : Created in 2021/3/26 7:04
 */
public class TypeVariableExample<K extends @MyAnnotation(1) InputStream & Closeable, V> {


    /**
     * TypeVariable的关键方法
     * 1.getBounds()：获取类型变量的上边界声明的数组，如果没有显示的声明则返回Object
     * 2.getName()：返回此类型变量的名称
     * 3.getGenericDeclaration()：返回声明这个类型变量的对象类型
     * 4.getAnnotatedBounds()：获取所有带注解的边界
     */

    // K 的上边界是 InputStream
    K key;
    // 没有指定的话 ，V 的 上边界 属于 Object
    V value;
    // 不属于 TypeTypeVariable
    V[] values;  // GenericArrayType
    String str;  // Class
    List<K> kList; // ParameterizedType

    public static void main(String[] args) throws NoSuchFieldException {


        TypeVariableExample bean = new TypeVariableExample<FileInputStream, String>();
        Field fk = TypeVariableExample.class.getDeclaredField("key");
        TypeVariable keyType = (TypeVariable) fk.getGenericType();

        // getBounds()表示此类型变量上边界的Type对象的数组
        System.out.println(Arrays.toString(keyType.getBounds()));
        // getName()返回此类型变量的名称
        System.out.println(keyType.getName());
        // getGenericDeclaration()返回表示声明此类型变量的泛型声明的GenericDeclaration对象
        System.out.println(keyType.getGenericDeclaration());
        // getAnnotatedBounds()获取所有带注解的边界
        Arrays.stream(keyType.getAnnotatedBounds()).forEach(type -> {
            System.out.println(type);
            System.out.println(Arrays.toString(type.getDeclaredAnnotations()));;
        });

        System.out.println("--------------------------------");
        Arrays.stream(bean.getClass().getDeclaredFields()).forEach(field -> {
            if (field.getGenericType() instanceof TypeVariable) {
                System.out.println(field.getName() + " is TypeVariable");
            } else if (field.getGenericType() instanceof ParameterizedType) {
                System.out.println(field.getName() + " is ParameterizedType");
            } else if (field.getGenericType() instanceof GenericArrayType) {
                System.out.println(field.getName() + " is GenericArrayType");
                // 对象的类型就是Class，比如java.lang.String, java.lang.Object
            } else if (field.getGenericType() instanceof Class) {
                System.out.println(field.getName() + " is Class");
            } else {
                System.out.println(field.getName() + " type is " + field.getGenericType());
            }
        });
    }
}
