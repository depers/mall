package cn.bravedawn.obj.inherit.polymorphic.codeblock.instance_initializer_block;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/1 17:30
 */
public class Bike2 {

    /**
     * 下面的代码中我们可以看到，初始化代码块先于构造函数代码块执行
     */

    int speed;

    Bike2() {
        System.out.println("constructor is invoked");
    }

    {
        System.out.println("instance initializer block invoked");
    }

    public static void main(String args[]) {
        Bike2 b2 = new Bike2();
    }
}
