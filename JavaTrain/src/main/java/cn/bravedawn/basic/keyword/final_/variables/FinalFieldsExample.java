package cn.bravedawn.basic.keyword.final_.variables;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/1 14:43
 */
public class FinalFieldsExample {

    /**
     * 对于 static final类字段的初始化时机
     *
     * 1. 在声明它的时候初始化它
     * 2. 在静态代码块初始化它
     */

    static final int a = 1;
    static final int b;

    static {
        b = 1;
    }

}
