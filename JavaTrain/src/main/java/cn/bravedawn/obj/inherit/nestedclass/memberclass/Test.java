package cn.bravedawn.obj.inherit.nestedclass.memberclass;

public class Test {

    /**
     * 定义一个内部类
     */

    public static void main(String[] args) {
        Outer outer = new Outer("Nested"); // 实例化一个Outer
        Outer.Inner inner = outer.new Inner(); // 实例化一个Inner
        inner.hello();
    }
}
