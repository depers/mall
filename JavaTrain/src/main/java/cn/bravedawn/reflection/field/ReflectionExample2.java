package cn.bravedawn.reflection.field;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class ReflectionExample2 {

    /**
     * Field类的常用操作
     */

    public static void main(String[] args) throws NoSuchFieldException {
        Class stdClass = Student.class;

        Field f = stdClass.getField("name");

        // 获取字段名称
        String name = f.getName();
        System.out.println(name); // name

        // 获取字段类型
        Class fieldType = f.getType();
        System.out.println(fieldType); // class java.lang.String

        // 获取字段的类型
        Type fieldType2 = f.getGenericType();
        System.out.println(fieldType2);

        // 返回字段的修饰符
        int m = f.getModifiers();
        System.out.println(m); // 1
        System.out.println(Modifier.isFinal(m)); // false
        System.out.println(Modifier.isPublic(m)); // true
        System.out.println(Modifier.isProtected(m)); // false
        System.out.println(Modifier.isPrivate(m)); // false
        System.out.println(Modifier.isStatic(m)); // false

    }
}
