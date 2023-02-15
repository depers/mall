package cn.bravedawn.jvm.excutor.slot;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/2/8 21:24
 */
public class SlotTest {

    /**
     * 实例方法 局部变量表中slot的位置分布
     */

    public int add(int a, int b) {
        int c = a + b;
        return a + b + c;


        // 这个方法中slot的排位
        // 0 -- this
        // 1 -- a
        // 2 -- b
        // 3 -- c
    }
}
