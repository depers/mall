package cn.bravedawn.basic.keyword.final_.variables;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/1 13:39
 */
public class FinalPrimitiveVariables {

    /**
     * 使用final修饰的原始类型变量，一旦初始化之后是不能再次赋值
     */

    public static void main(String[] args) {
        final int i = 1;

        // 不能修改i
        // i = 2;
    }
}
