package cn.bravedawn.obj.inherit.polymorphic.codeblock.staticmethod;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/7/8 10:13
 */
public class Test {

    /**
     * 测试在调用静态方法的时候会不会执行【实例初始化代码块】、【静态代码块】
     * 经过实验发现，在调用一个类的静态方法的时候只会调用其【静态代码块】有且只有一次，然后是【静态方法】，不会调用【实例初始化代码块】
     */

    public static void main(String[] args) {
        Util.test();

        Util.test();
    }
}
