package cn.bravedawn.reflection.field;

import java.lang.reflect.Field;

public class ReflectionExample3 {

    /**
     * 获取字段值（包括访问private修饰的字段）
     */

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Object p = new People("冯晓");
        Class c = p.getClass();
        Field f = c.getDeclaredField("name");
        Object value = f.get(p);
        System.out.println(value);

        System.out.println("--------------------------");
        Object o = new People("冯晓2", 18);
        Class c2 = o.getClass();
        Field f2 = c2.getDeclaredField("age");
        // 别管这个字段是不是public，一律允许访问
        f2.setAccessible(true);
        Object v = f2.get(o);
        System.out.println(v);
    }
}
