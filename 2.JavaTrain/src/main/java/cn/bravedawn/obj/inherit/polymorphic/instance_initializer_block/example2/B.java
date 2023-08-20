package cn.bravedawn.obj.inherit.polymorphic.instance_initializer_block.example2;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/1 18:05
 */
public class B extends A{

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
