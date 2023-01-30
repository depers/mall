package cn.bravedawn.jvm.triggerclassinit.initiative;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/28 21:41
 */
public interface MyInterface {

    default void t2() {
        System.out.println("MyInterface default method t2()");
    }
}
