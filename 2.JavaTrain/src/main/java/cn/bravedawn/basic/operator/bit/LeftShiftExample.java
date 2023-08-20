package cn.bravedawn.basic.operator.bit;

import org.apache.commons.lang.StringUtils;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/16 17:24
 */
public class LeftShiftExample {

    /**
     * Java中左移位操作符的使用
     * 需要注意：
     *  1.左位移被理解为乘2操作，但是左位移是有可能会产生负数的
     *  2.int类型左位移超过32位会进行取余操作，long类型类似
     */


    public static void main(String[] args) {
        int intValue = 733183670;
        System.out.println("intValue的二进制：" + StringUtils.leftPad(Integer.toBinaryString(intValue), 32, "0"));

        System.out.println("intValue左移4位的二进制数为：" + StringUtils.leftPad(Integer.toBinaryString(intValue << 4), 32, "0")
                        + ", intValue左移4位：" + (intValue << 4));

        System.out.println("intValue左移8位的二进制数为：" + StringUtils.leftPad(Integer.toBinaryString(intValue << 8), 32, "0")
                + ", intValue左移8位：" + (intValue << 8));

        System.out.println("intValue左移40位的二进制数为：" + StringUtils.leftPad(Integer.toBinaryString(intValue << 40), 32, "0")
                + ", intValue左移40位：" + (intValue << 40));
    }
}
