package cn.bravedawn.jvm.memory;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/2/8 20:50
 */
public class StackSizeTest {

    /**
     * 演示虚拟机栈大小的配置效果
     */

    private int num;

    private int callMe(int a, int b) {
        num++;
        return callMe(a+num, b);
    }

    public static void main(String[] args) {
        StackSizeTest test = new StackSizeTest();
        try {
            test.callMe(1, 2);
        } catch (Throwable e) {
            System.out.println("num = " + test.num);
            e.printStackTrace();
        }
    }
}
