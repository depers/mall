package cn.bravedawn.obj.inherit.polymorphic.overloading.overload_null_error;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/3 17:02
 */
public class OverloadingNullError2 {

    /**
     * 将null赋值给明确数据类型的变量之后，再传递给重载方法，就是正常的
     *
     * 下面代码中我们将null先赋值给了一个明确类型的变量，而不是直接当做实参传入时。Java编译器会根据明确的类型选择正确的重载方法
     */

    // Overloaded methods
    public void fun(Integer i) {
        System.out.println("fun(Integer ) ");
    }
    public void fun(String name) {
        System.out.println("fun(String ) ");
    }


    // Driver code
    public static void main(String [] args)
    {
        OverloadingNullError2 mv = new OverloadingNullError2();

        Integer arg = null;

        // No compiler error
        mv.fun(arg);
    }

}
