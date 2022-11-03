package cn.bravedawn.obj.inherit.polymorphic.overloading.overload_null_error;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/3 16:58
 */
public class OverloadingNullError {

    /**
     * 不要直接将null作为实参直接传递给形参为包装类型的重载方法，否则会编译错误
     *
     * 在下面场景中我们得到编译时错误的原因是，这里的方法参数 Integer 和 String 都不是 Java 中的原始数据类型。
     * 这意味着它们接受空值。当我们将空值传递给方法 1 时，编译器会混淆它必须选择哪个方法，因为两者都接受空值。
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
        OverloadingNullError mv = new OverloadingNullError();

        // This line causes error
        // mv.fun(null);
    }

}
