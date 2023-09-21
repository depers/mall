package cn.bravedawn.obj.inherit.polymorphic.codeblock;

/**
 * @Description : 静态代码块
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-09-21 11:12
 */
public class StaticCodeBlock {

    /**
     * 静态代码块
     * 作用：对类进行一些初始化，只加载一次。
     * 调用：当new多个对象时，只有在第一次new对象的时候调用一次静态代码块，因为静态代码块和类变量一样，是属于类的，所有对象共享一份。
     */


    private static int a;

    static {
        a = 1;
        System.out.println("调用静态代码块，a=" + a);
    }

    public StaticCodeBlock() {
        System.out.println("调用类的构造方法");
    }


    public static void main(String[] args) {
        StaticCodeBlock block = new StaticCodeBlock();
        StaticCodeBlock block2 = new StaticCodeBlock();
    }
}
