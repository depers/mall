package cn.bravedawn.obj.inherit.downcasting;

public class InstanceofExample {

    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p instanceof Person); // true
        System.out.println(p instanceof Student); // false

        Student s = new Student();
        System.out.println(s instanceof Person); // true
        System.out.println(s instanceof Student); // true

        Student stu = null;
        System.out.println(stu instanceof Student); // false
    }
}
