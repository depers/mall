package cn.bravedawn.obj.inherit.downcasting;

public class Test {

    public static void main(String[] args) {
        Person p1 = new Student(); // upcasting ok
        Person p2 = new Person();

        Student s1 = (Student) p1; // downcasting ok
        Student s2 = (Student) p2; // runtime error! ClassCastException
    }
}
