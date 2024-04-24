package cn.bravedawn.jvm.triggerclassinit.passivity.parentstaticvariable;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/30 20:49
 */
public class SubClass extends SuperClass{

    static {
        System.out.println("子类正在初始化");
    }
}
