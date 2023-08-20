package cn.bravedawn.jvm.classinit.interfaceinit;

import cn.bravedawn.jvm.classinit.MyChild;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/28 21:04
 */
public class Test {


    // 子类调用接口的变量

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        System.out.println(myClass.a);
        myClass.t1();
    }
}
