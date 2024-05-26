package cn.bravedawn.obj.inherit.instanceof_;

public class Student extends Person implements WorkOperator{


    private void hello(){
        System.out.println("Student子类的hello");
        print();
    }
}
