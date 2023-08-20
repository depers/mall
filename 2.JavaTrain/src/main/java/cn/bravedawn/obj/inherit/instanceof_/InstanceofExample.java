package cn.bravedawn.obj.inherit.instanceof_;


public class InstanceofExample {

    /**
     * 对象的实例使用 instanceOf 比较其父类和接口
     */

    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p instanceof Person); // true
        System.out.println(p instanceof Student); // false

        Student s = new Student();
        System.out.println(s instanceof Person); // true
        System.out.println(s instanceof Student); // true
        System.out.println(s instanceof WorkOperator); // true

        Student stu = null;
        System.out.println(stu instanceof Student); // false
    }
}
