package cn.bravedawn.jvm.excutor.operandstack;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/2/15 21:35
 */
public class OperandStackTest {

    /**
     * 局部变量表中操作数栈的演示
     */

    public int add(int a, int b) {
        int c = a + b;
        return a + b + c;
    }

    public static void main(String[] args) {
        OperandStackTest test = new OperandStackTest();
        int ret = test.add(1, 2);
        System.out.println("ret = " + ret);
    }
}
