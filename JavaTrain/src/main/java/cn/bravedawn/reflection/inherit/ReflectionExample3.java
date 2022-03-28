package cn.bravedawn.reflection.inherit;

public class ReflectionExample3 {

    /**
     * 对所有interface的Class调用getSuperclass()返回的是null，获取接口的父接口要用getInterfaces()
     */


    public static void main(String[] args) {

        Class cls = Comparable.class;
        System.out.println(cls.getSuperclass()); // null
    }
}
