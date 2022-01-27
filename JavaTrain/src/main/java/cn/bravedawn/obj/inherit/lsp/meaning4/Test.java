package cn.bravedawn.obj.inherit.lsp.meaning4;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/27 7:48
 */
public class Test {

    /**
     * 当子类的方法实现父类的方法时（<b>重写/重载或实现抽象方法</b>），方法的后置条件（即方法的输出/返回值）要比父类更严格或相等（<b>小于等于</b>）。
     * （例如父类方法的返回值为Map，则子类的入参应该为Map或为HashMap）
     *
     * 若在继承时，子类的方法返回值类型范围比父类的方法返回值类型范围大，在子类重写该方法时编译器会报错。
     */

    public static void main(String[] args) {
        A a = new B();
        a.fun();

    }
}
