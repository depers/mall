package cn.bravedawn.jvm.triggerclassinit.passivity.parentstaticvariable;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/30 20:49
 */
public class Test {

    /**
     * 被动引用案例一：
     * 通过子类访问父类的静态变量，不会导致子类的初始化
     */

    public static void main(String[] args) {
        System.out.println(SubClass.name);
    }
}
