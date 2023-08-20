package cn.bravedawn.obj.inherit.lsp.meaning1;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/24 14:38
 */
public class Test {

    /**
     * 含义一：子类必须实现父类的抽象方法，但不得重写（覆盖）父类的非抽象（已实现）方法
     *
     * 如下面父类A和子类B之间的关系，子类重写的父类的方法，导致相同的方法的实现不同，导致程序的逻辑发生了变化。
     */

    public static void main(String[] args) {
        System.out.println("父类的运行结果");
        A a = new A();
        a.fun(1, 2);

        System.out.println("子类替换父类后的运行结果");
        B b = new B();
        b.fun(1, 2);
    }
}
