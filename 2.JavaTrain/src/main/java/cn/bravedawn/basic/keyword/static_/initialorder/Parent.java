package cn.bravedawn.basic.keyword.static_.initialorder;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/18 15:26
 */
public class Parent {

    static String a = "父类静态变量";

    String field = "父类实例变量";


    static {
        System.out.println("Parent的静态变量 a=" + a);
        System.out.println("Parent的静态代码块");
    }

    {
        System.out.println("Parent 实例变量 field=" + field);
        System.out.println("Parent 普通代码块");
    }

    Parent() {
        System.out.println("Parent 构造函数");
    }
}
