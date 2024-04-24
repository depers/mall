package cn.bravedawn.obj.inherit.polymorphic.codeblock.instance_initializer_block.example2;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/1 18:05
 */
public class B extends A{

    /**
     * 这个例子主要显示了通过调用子类不同的构造函数，从而执行不同的构造函数逻辑
     */

    B() {
        super();
        System.out.println("child class constructor invoked");
    }

    B(int a) {
        super();
        System.out.println("child class constructor invoked "+ a);
    }

    {
        System.out.println("instance initializer block is invoked");
    }

    public static void main(String[] args) {
        B b = new B();
        /**
         * 执行结果：
         * parent class constructor invoked
         * instance initializer block is invoked
         * child class constructor invoked
         */

        B b2 = new B(1);
        /**
         * 执行结果：
         * parent class constructor invoked
         * instance initializer block is invoked
         * child class constructor invoked 1
         */
    }
}
