package cn.bravedawn.jvm.triggerclassinit.passivity.array;

import cn.bravedawn.jvm.triggerclassinit.passivity.parentstaticvariable.SuperClass;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/30 20:52
 */
public class NotInitialization {

    /**
     * 被动引用案例二：
     * 通过数组定义来引用类，不会触发此类的初始化
     */

    public static void main(String[] args) {
        SuperClass[] arrays = new SuperClass[10];
        System.out.println("数组元素个数：" + arrays.length);

    }
}
