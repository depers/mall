package cn.bravedawn.basic.operator.bit;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/14 22:56
 */
public class ShiftExample {

    /**
     * 移位运算
     */


    public static void main(String[] args) {

        Integer a = 16;
        System.out.println(Integer.toBinaryString(a)); // 101
        System.out.println(a << 1); // 左移相当于乘2
        System.out.println(a >> 1); // 右移相当于除2
        System.out.println(a >>> 1); // 无符号右移两位

        a = -16;
        System.out.println(Integer.toBinaryString(a)); // 101
        System.out.println(a << 1); // 左移相当于乘2
        System.out.println(a >> 1); // 右移相当于除2
        System.out.println(a >>> 1); // 无符号右移两位
    }
}
