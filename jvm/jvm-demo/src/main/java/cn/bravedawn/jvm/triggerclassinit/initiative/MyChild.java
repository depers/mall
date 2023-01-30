package cn.bravedawn.jvm.triggerclassinit.initiative;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/28 21:41
 */
public class MyChild extends MyParent implements MyInterface{

    static {
        System.out.println("My child class init");
    }

    public static int a = 1;

    public static void t1() {
        System.out.println("MyChild class t1() method");
    }
}
