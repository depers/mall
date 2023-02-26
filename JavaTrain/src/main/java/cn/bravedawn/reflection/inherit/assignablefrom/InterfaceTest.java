package cn.bravedawn.reflection.inherit.assignablefrom;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/26 19:02
 */

interface InterfaceA{
}

class ClassB implements InterfaceA{

}
class ClassC implements InterfaceA{

}
class ClassD extends ClassB{

}

public class InterfaceTest {

    /**
     * isAssignableFrom()判断当前的Class对象所表示的类，是不是参数中传递的Class对象所表示的类的父类，超接口，或者是相同的类型。是则返回true，否则返回false
     */

    public static void main(String[] args) {
        System.out.println(InterfaceA.class.isAssignableFrom(InterfaceA.class)); // true
        System.out.println(InterfaceA.class.isAssignableFrom(ClassB.class)); // true
        System.out.println(InterfaceA.class.isAssignableFrom(ClassC.class)); // true
        System.out.println(ClassB.class.isAssignableFrom(ClassC.class)); // false
        System.out.println("============================================");

        System.out.println(ClassB.class.isAssignableFrom(ClassD.class)); // true
        System.out.println(InterfaceA.class.isAssignableFrom(ClassD.class)); // true
    }
}
