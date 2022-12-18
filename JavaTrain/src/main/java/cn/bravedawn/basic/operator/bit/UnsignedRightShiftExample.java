package cn.bravedawn.basic.operator.bit;

import org.apache.commons.lang.StringUtils;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/16 23:14
 */
public class UnsignedRightShiftExample {

    /**
     * Java中无符号右移运算符的使用
     */


    public static void main(String[] args) {
        int intValue = -733183670;
        System.out.println("intValue的二进制：" + StringUtils.leftPad(Integer.toBinaryString(intValue), 32, "0"));

        System.out.println("intValue无符号右移8位的二进制为：" + Integer.toBinaryString(intValue >>> 8)
                    + ", intValue无符号右移8位：" + (intValue >>> 8));
    }
}
