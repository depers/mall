package cn.bravedawn.obj.inherit.instanceof_;

public class Person {

    protected void print() {
        System.out.println("Person输出");

        if (this instanceof Student) {
            System.out.println("是子类Student调用了我");
        }
        if (this instanceof Teacher) {
            System.out.println("是子类Teacher调用了我");
        }
    }


}
