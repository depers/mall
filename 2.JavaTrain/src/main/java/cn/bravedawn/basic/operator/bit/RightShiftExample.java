package cn.bravedawn.basic.operator.bit;

import org.apache.commons.lang.StringUtils;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/16 22:55
 */
public class RightShiftExample {

    /**
     * Java中右移运算符的使用
     * 右移一位相当于除2，右移2位相当于除4，右移3位相当于除8，依次类推
     */

    public static void main(String[] args) {
        int intValue = 733183670;

        System.out.println("intValue的二进制：" + StringUtils.leftPad(Integer.toBinaryString(intValue), 32, "0"));

        // 因intValue是正数，所以右移在左侧补0
        System.out.println("intValue右移8位的二进制数为：" + StringUtils.leftPad(Integer.toBinaryString(intValue >> 8), 32, "0")
                        + ", intValue右移8位：" + (intValue >> 8));

        int negativeValue = -733183670;
        // 负数的话，Integer.toBinaryString会将符号位补全
        System.out.println("negativeValue的二进制：" + Integer.toBinaryString(negativeValue));

        // 因为negativeValue是负数，所以右移在左侧补1
        System.out.println("negativeValue右移8位的二级制数为：" + Integer.toBinaryString(negativeValue >> 8));
    }
}
