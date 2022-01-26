package cn.bravedawn.obj.accessright.protected1;

public class Test {

    /**
     * 同一个包的不同类是可以访问 <b>protected</b> 修饰符的方法，内部类
     */

    public static void main(String[] args) {
        A a = new A();
        a.method();

        A.InnerClass innerClass = a.new InnerClass();
        innerClass.innerMethod();
    }
}
