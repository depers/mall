package cn.bravedawn.obj.inherit.upcasting;

public class Test {

    public static void main(String[] args) {


        // 这种把一个子类类型安全地变为父类类型的赋值，被称为向上转型（upcasting）
        Person ps = new Student();

        Student s = new Student();
        Person p = s;
        Object o = p;
        Object o1 = s;

    }
}
