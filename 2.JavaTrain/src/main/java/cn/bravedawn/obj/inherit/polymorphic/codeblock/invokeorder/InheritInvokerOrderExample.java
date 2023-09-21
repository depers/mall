package cn.bravedawn.obj.inherit.polymorphic.codeblock.invokeorder;

/**
 * @Description : 有继承关系的代码块加载顺序
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-09-21 10:56
 */
public class InheritInvokerOrderExample {

    /**
     * 有继承关系的调用顺序：父类静态静态代码块（静态成员变量） -> 子类静态静态代码块（静态成员变量）
     *                   -> 父类普通代码块（普通成员变量） -> 子类普通代码块（普通成员变量）
     *                   -> 父类构造函数代码块 -> 子类构造函数代码块
     */

    public static void main(String[] args) {
        Student student = new Student("小明", 21, "男");

    }
}
