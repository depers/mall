package cn.bravedawn.obj.inherit.superp;

public class Student2 extends Person2{

    /**
     * 子类的构造方法中会默认调用父类的默认构造方法
     */

    protected int score;

    public Student2(String name, int age, int score) {
        // super(); // 这一句编译器会自己加上去，自动调用父类的构造方法
        this.score = score;
    }
}
