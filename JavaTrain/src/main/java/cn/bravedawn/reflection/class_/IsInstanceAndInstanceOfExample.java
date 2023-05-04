package cn.bravedawn.reflection.class_;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/5/4 16:36
 */


interface A {
}

class B {
}

class C implements A {
}

class D extends B {
}

public class IsInstanceAndInstanceOfExample {


    /**
     * 比较instanceof与class.isInstance之间的区别
     */

    public static void main(String[] args) {
        C t1 = new C();
        D t2 = new D();

        // obj instanceof class:这个对象是不是这种类型.
        // 测试1:一个对象是本身类的一个对象
        System.out.println(t1 instanceof C); // true
        System.out.println(t2 instanceof D); // true
        System.out.println("============");

        // 测试2:一个对象是本身类父类(父类的父类)和接口的一个对象
        System.out.println(t1 instanceof A); // true
        System.out.println(t2 instanceof B); // true
        System.out.println("============");

        // 测试3:所有对象都是object
        System.out.println(t1 instanceof Object); // true
        System.out.println(t2 instanceof Object); // true
        System.out.println("============");

        // 测试4:凡是null相关的都是false
        System.out.println(null instanceof Object); // false
        System.out.println(null instanceof B); // true
        System.out.println("============");

        // class.isInstance(obj):这个对象能不能被转化为这个类
        // 测试1:一个对象是本身类的一个实例
        System.out.println(C.class.isInstance(t1)); // true
        System.out.println("============");

        // 测试2:一个对象能被转化为本身类所继承的类(父类的父类)和实现的接口(接口的父接口)强转
        System.out.println(A.class.isInstance(t1)); // true
        System.out.println(B.class.isInstance(t2)); // true
        System.out.println("============");

        // 测试3:所有对象都能被Object强转
        System.out.println(Object.class.isInstance(t1)); // true
        System.out.println(Object.class.isInstance(t2)); // true
        System.out.println("============");

        // 测试4:凡是和null相关的都是false
        System.out.println(Object.class.isInstance(null)); // false
        System.out.println(D.class.isInstance(null)); // false
    }
}
