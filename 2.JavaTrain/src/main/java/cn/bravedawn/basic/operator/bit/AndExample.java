package cn.bravedawn.basic.operator.bit;

import org.apache.commons.lang3.StringUtils;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/3/13 12:13
 */
public class AndExample {

    /**
     * 由下面的案例我们可知，奇数和1做与运算是等于1的，偶数与1做与运算是等于0的
     */


    public static void main(String[] args) {
        int a = 1; // 0001
        int b = 2; // 0010
        int c = 3; // 0011
        int d = 4; // 0100

        System.out.println(a & 1); // 1
        System.out.println(b & 1); // 0
        System.out.println(c & 1); // 1
        System.out.println(d & 1); // 0

        System.out.println("15的二级制数：" + StringUtils.leftPad(Integer.toBinaryString(15), 32, "0"));
        System.out.println("15的二级制数：" + StringUtils.leftPad(Integer.toBinaryString(1949), 32, "0"));
        System.out.println(15 & 1949); // 13
        System.out.println(15 & 1950); // 14
        System.out.println(16 & 1949); // 16
        System.out.println(16 & 1950); // 16
        System.out.println("-------");
        System.out.println(21 & 1949); // 13
        System.out.println(21 & 1950); // 14
        System.out.println(22 & 1949); // 16
        System.out.println(22 & 1950); // 16

    }
}
