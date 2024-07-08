package cn.bravedawn.obj.inherit.polymorphic.codeblock.staticmethod;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/7/8 10:12
 */
public class Util {

    {
        System.out.println("实例化代码块");
    }

    static {
        System.out.println("静态代码块");
    }

    public Util() {
        System.out.println("构造方法");
    }

    public static void test() {
        System.out.println("静态方法");
    }

}
