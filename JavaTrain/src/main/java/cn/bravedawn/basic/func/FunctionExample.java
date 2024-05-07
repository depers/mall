package cn.bravedawn.basic.func;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/5/6 15:43
 */
public class FunctionExample {

    /**
     * 值传递和引用传递
     *
     * 结论：对于基本数据类型和其包装类型，是按值传递的
     */


    public void func(int a) {
        a = 0;
    }

    public void func2(Integer a) {
        a = 0;
    }

    public void func3(int a) {
        a = 0;
        System.out.println("func3中的a=" + a);
    }

    public void func4(Integer a) {
        a = 0;
        System.out.println("func4中的a=" + a);
    }


    public static void main(String[] args) {
        FunctionExample example = new FunctionExample();
        int a = 1;
        int b = 2;
        example.func(a);
        System.out.println("a=" + a);

        example.func2(b);
        System.out.println("b=" + b);

        example.func3(a);
        System.out.println("a=" + a);

        example.func4(b);
        System.out.println("b=" + b);
    }

}

