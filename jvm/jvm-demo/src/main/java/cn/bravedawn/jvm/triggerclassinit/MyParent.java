package cn.bravedawn.jvm.triggerclassinit;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/28 21:54
 */
public class MyParent {

    static {
        System.out.println("My Parent class init");
    }
}
