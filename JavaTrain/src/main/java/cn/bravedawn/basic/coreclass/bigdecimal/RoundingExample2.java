package cn.bravedawn.basic.coreclass.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/28 13:26
 */
public class RoundingExample2 {

    /**
     * 四舍五入
     * RoundingMode.FLOOR的使用
     */

    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("1.213");
        BigDecimal b2 = new BigDecimal("1.216");
        BigDecimal b3 = new BigDecimal("-1.213");
        BigDecimal b4 = new BigDecimal("-1.216");

        b1 = b1.setScale(2, RoundingMode.FLOOR);
        b2 = b2.setScale(2, RoundingMode.FLOOR);
        b3 = b3.setScale(2, RoundingMode.FLOOR);
        b4 = b4.setScale(2, RoundingMode.FLOOR);

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
    }




}
