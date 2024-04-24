package cn.bravedawn.reflection.field;

import java.lang.reflect.Field;

public class ReflectionExample4 {


    /**
     * 修改一段值（包括修改private修饰的字段的值）
     */

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        People o = new People("冯晓", 18);
        System.out.println(o.getAge());

        Class c = o.getClass();
        Field f = c.getDeclaredField("age");
        // 别管这个字段是不是public，一律允许访问
        f.setAccessible(true);
        f.set(o, 19);
        System.out.println(o.getAge());
    }
}
