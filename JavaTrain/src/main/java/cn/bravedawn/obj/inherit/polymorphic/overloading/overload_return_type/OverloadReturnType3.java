package cn.bravedawn.obj.inherit.polymorphic.overloading.overload_return_type;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/3 13:21
 */
public class OverloadReturnType3 {

    public int foo(int a) { return 10; }

    public char foo(int a, int b) { return 'a'; }

    public static void main(String args[])
    {
        OverloadReturnType3 a = new OverloadReturnType3();
        System.out.println(a.foo(1));
        System.out.println(a.foo(1, 2));
    }
}
