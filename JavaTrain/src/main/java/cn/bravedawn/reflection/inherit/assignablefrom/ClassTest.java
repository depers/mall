package cn.bravedawn.reflection.inherit.assignablefrom;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/26 18:54
 */


class A{

}


class B extends A{}

class C extends B{}

public class ClassTest{

    /**
     * isAssignableFrom()判断当前的Class对象所表示的类，是不是参数中传递的Class对象所表示的类的父类，超接口，或者是相同的类型。是则返回true，否则返回false
     * 下面的测试说明：最顶级的父类也是Object，也就是所有的类型都可以转换成为Object。
     */

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        B b1 = new B();
        C c = new C();
        System.out.println(a.getClass().isAssignableFrom(a.getClass())); // true
        System.out.println(a.getClass().isAssignableFrom(b.getClass())); // true
        System.out.println(a.getClass().isAssignableFrom(c.getClass())); // true
        System.out.println(b1.getClass().isAssignableFrom(b.getClass())); // true
        System.out.println(b.getClass().isAssignableFrom(c.getClass())); // true

        System.out.println("=====================================");
        System.out.println(A.class.isAssignableFrom(a.getClass())); // true
        System.out.println(A.class.isAssignableFrom(b.getClass())); // true
        System.out.println(A.class.isAssignableFrom(c.getClass())); // true

        System.out.println("=====================================");
        System.out.println(Object.class.isAssignableFrom(a.getClass())); // true
        System.out.println(Object.class.isAssignableFrom(String.class)); // true
        // String不是Object的相同类型或是父类，所以报false
        System.out.println(String.class.isAssignableFrom(Object.class)); // false
    }
}
