package cn.bravedawn.obj.accessright.protected2;

import cn.bravedawn.obj.accessright.protected1.A;

public class C {

    /**
     * 对于不同包的不同类是不能访问 <b>protected</b> 修饰符的方法，内部类
     */

    public static void main(String[] args) {
        A a = new A();
        // a.method();

        //A.InnerClass innerClass = a.new InnerClass();
        //innerClass.innerMethod();
    }
}
