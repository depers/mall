package cn.bravedawn.obj.inherit.protectedp;

public class Student extends Person{

    /**
     * protected关键字可以把字段和方法的访问权限控制在继承树内部，一个protected字段和方法可以被其子类，以及子类的子类所访问，
     */

    public String hello() {
        return "hello" + name;
    }
}
