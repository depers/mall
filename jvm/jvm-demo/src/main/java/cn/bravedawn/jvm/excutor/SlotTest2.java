package cn.bravedawn.jvm.excutor;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/2/8 21:36
 */
public class SlotTest2 {

    /**
     * 静态方法 局部变量表中slot的位置分布
     */

    public static int add(int a, int b) {
        int c = a + b;
        return a + b + c;


        // 这个方法中slot的排位
        // 0 -- a
        // 1 -- b
        // 2 -- c
    }
}
