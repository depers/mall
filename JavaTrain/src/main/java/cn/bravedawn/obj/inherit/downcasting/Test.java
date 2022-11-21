package cn.bravedawn.obj.inherit.downcasting;

public class Test {

    /**
     * 向下转型，将父类的类型转变成子类的类型称为向下转型。在Java中是父类类型是不可以转为子类类型的
     */

    public static void main(String[] args) {
        Person p1 = new Student(); // upcasting ok
        Person p2 = new Person();

        Student s1 = (Student) p1; // downcasting ok
        Student s2 = (Student) p2; // runtime error! ClassCastException
    }
}
