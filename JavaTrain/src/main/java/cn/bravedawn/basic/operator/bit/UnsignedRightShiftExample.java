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
     *
     */


    public static void main(String[] args) {
        int intValue = -733183670;
        System.out.println("intValue的二进制：" + StringUtils.leftPad(Integer.toBinaryString(intValue), 32, "0"));

    }
}
