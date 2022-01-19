package cn.bravedawn.basic.keyword.staticp.initialorder;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/18 15:27
 */
public class Child extends Parent{

    static String a = "子类静态变量";

    String field = "子类实例变量";

    static {
        System.out.println("Child的静态变量 a=" + a);
        System.out.println("Child的静态代码块");
    }

    {
        System.out.println("Child 实例变量 field=" + field);
        System.out.println("Child 普通代码块");
    }

    Child() {
        System.out.println("Child 构造函数");
    }
}
