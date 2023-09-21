package cn.bravedawn.obj.inherit.polymorphic.codeblock.invokeorder;

/**
 * @Description : 无继承关系的代码块的加载顺序
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-09-21 10:31
 */
public class InvokeOrderExample {


    /**
     * 无继承关系的调用顺序：静态代码块 -> 实例初始化代码块 -> 构造函数代码块
     */

    private static int a;
    private int b;


    static {
        a = 1;
        System.out.println("调用静态代码块, a=" + a);
    }

    {
        b = 2;
        System.out.println("调用实例初始化代码块, b=" + b);
    }


    public InvokeOrderExample() {
        System.out.println("调用构造函数代码块");
    }

    public static void main(String[] args) {
        InvokeOrderExample example = new InvokeOrderExample();

        /**
         * 输出：
         * 调用静态代码块, a=1
         * 调用实例初始化代码块, b=2
         * 调用构造函数代码块
         */
    }

}
