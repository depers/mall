package cn.bravedawn.jvm.triggerclassinit.passivity.parentstaticvariable;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/30 20:48
 */
public class SuperClass {

    static {
        System.out.println("父类正在初始化");
    }

    public static String name = "app";
}
