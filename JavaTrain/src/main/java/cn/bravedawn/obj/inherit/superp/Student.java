package cn.bravedawn.obj.inherit.superp;

public class Student extends Person{

    /**
     * 若父类定义了构造方法，需要在子类的构造方法中通过super关键字显式的调用父类的构造方法
     */

    protected int score;

    public Student(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }

}
