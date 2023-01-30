package cn.bravedawn.jvm.triggerclassinit.passivity.constant;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/30 20:55
 */
public class Test {

    /**
     * 被动引用案例三：
     * 常量在编译阶段会存入调用类的常量池中，本质没有直接引用到定义的常量的类，不会触发定义常量的类的初始化
     */

    public static void main(String[] args) {
        System.out.println(ConstClass.name);
    }
}
