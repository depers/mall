package cn.bravedawn.reflection.inherit;

public class ReflectionExample {

    /**
     * 获取父类的Class
     */

    public static void main(String[] args) {
        Class i = Integer.class;
        Class n = i.getSuperclass();
        System.out.println(n); // class java.lang.Number

        Class o = n.getSuperclass();
        System.out.println(o); // class java.lang.Object
        System.out.println(o.getSuperclass()); // null
    }
}
