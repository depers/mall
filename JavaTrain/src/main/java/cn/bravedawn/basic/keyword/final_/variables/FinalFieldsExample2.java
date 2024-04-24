package cn.bravedawn.basic.keyword.final_.variables;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/1 14:46
 */
public class FinalFieldsExample2 {

    /**
     * 对final修饰的类字段的初始化时机：
     * 1. 在声明的时候初始化该字段
     * 2. 在实例初始化代码块中初始化该字段
     * 3. 在构造函数中初始化该字段
     */


    private final int a = 1;

    private final int b;

    private final int c;

    {
        b = 2;
    }

    FinalFieldsExample2() {
        c = 3;
    }


}
