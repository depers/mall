package cn.bravedawn.jvm.classinit;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/28 20:51
 */
public class MyChild extends MyParent{

    static {
        System.out.println("My child class init");
    }

    static {
        System.out.println("My child static block 2");
    }

    private static int a = 5;

    static {
        System.out.println("My child static block 3, a=" + a);
    }
}
