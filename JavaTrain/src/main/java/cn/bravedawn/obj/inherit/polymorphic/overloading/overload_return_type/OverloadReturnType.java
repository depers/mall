package cn.bravedawn.obj.inherit.polymorphic.overloading.overload_return_type;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/3 13:15
 */
public class OverloadReturnType {


    public int foo() {
        return 10;
    }

    // compiler error: foo() is already defined
    //public char foo() {
    //   return 'a';
    //}

    public static void main(String[] args) {

    }

}
