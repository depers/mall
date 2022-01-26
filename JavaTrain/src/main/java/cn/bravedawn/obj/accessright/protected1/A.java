package cn.bravedawn.obj.accessright.protected1;

public class A {

    protected void method() {
        System.out.println("protect方法输出");
    }


    protected class InnerClass {

        void innerMethod() {
            System.out.println("protected修复符修饰内部类");
        }
    }
}
