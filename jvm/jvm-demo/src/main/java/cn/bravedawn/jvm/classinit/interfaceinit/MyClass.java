package cn.bravedawn.jvm.classinit.interfaceinit;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/28 20:58
 */
public class MyClass implements Child{

    @Override
    public void t1() {
        System.out.println("now init MyClass t1 method");
    }
}
