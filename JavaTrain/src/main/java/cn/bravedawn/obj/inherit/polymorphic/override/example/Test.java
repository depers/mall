package cn.bravedawn.obj.inherit.polymorphic.override.example;

public class Test {

    /**
     * 在下面这段代码中，引用对象的类型是Student，实例变量的类型是Person，实际调用的是Student的run方法
     * 结论：Java的实例方法调用是基于运行时的实际类型的动态调用，而非变量的声明类型。
     * 从而引出了多态的概念：多态是指，针对某个类型的方法调用，其真正执行的方法取决于运行时期实际类型的方法
     */

    public static void main(String[] args) {
        Person p = new Student();
        p.run();
    }
}
