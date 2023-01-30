package cn.bravedawn.jvm.triggerclassinit.passivity.constant;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/30 20:55
 */
public class ConstClass {

    static {
        System.out.println("有常量的类正在初始化");
    }

    public final static String name = "app";
}
