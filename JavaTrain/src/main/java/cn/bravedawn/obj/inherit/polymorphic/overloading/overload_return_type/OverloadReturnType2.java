package cn.bravedawn.obj.inherit.polymorphic.overloading.overload_return_type;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/3 13:20
 */
public class OverloadReturnType2 {

    public static int foo(int a) {
        return 10;
    }

    public static char foo(int a, int b) {
        return 'a';
    }

    public static void main(String args[])
    {
        System.out.println(foo(1));
        System.out.println(foo(1, 2));
    }
}
