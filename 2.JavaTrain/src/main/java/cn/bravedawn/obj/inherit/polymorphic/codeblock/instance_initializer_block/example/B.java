package cn.bravedawn.obj.inherit.polymorphic.codeblock.instance_initializer_block.example;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/1 18:04
 */
public class B extends A{

    /**
     * 实例初始化代码块的初始化过程
     * 1.先执行实例类的构造器中父类构造器（super()方法）
     * 2.执行实例初始化代码块
     * 3.执行实例类的构造器中的代码
     */

    B() {
        super();
        System.out.println("child class constructor invoked");
    }

    {
        System.out.println("instance initializer block is invoked");
    }

    public static void main(String[] args) {
        B b = new B();
    }

    /**
     * 执行结果：
     * parent class constructor invoked
     * instance initializer block is invoked
     * child class constructor invoked
     */
}
