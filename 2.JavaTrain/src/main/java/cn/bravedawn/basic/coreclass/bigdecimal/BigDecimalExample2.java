package cn.bravedawn.basic.coreclass.bigdecimal;

import java.math.BigDecimal;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/28 11:12
 */
public class BigDecimalExample2 {

    /**
     * BigDecimal的精度，范围（小数位数），符号
     */

    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal("-12345.6789");

        System.out.println(bd.precision()); // 返回这个BigDecimal的精度。(精度是指未缩放值中的位数)。也就是123456789的长度
        System.out.println(bd.scale()); // 小数点后的位数
        System.out.println(bd.signum()); // 返回BigDecimal的符号，正数为1，负数为-1,0为0
    }
}
