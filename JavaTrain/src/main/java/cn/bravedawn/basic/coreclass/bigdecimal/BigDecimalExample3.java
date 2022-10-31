package cn.bravedawn.basic.coreclass.bigdecimal;

import java.math.BigDecimal;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/28 11:29
 */
public class BigDecimalExample3 {

    /**
     * BigDecimal的比较
     * 1.compareTo()方法在比较的时候会忽略了刻度，【推荐使用】
     * 2.equals()方法只在两个BigDecimal对象的值和刻度相等时才认为它们相等
     */

    public static void main(String[] args) {
        BigDecimal bd1 = new BigDecimal("1.0");
        BigDecimal bd2 = new BigDecimal("1.00"); // compareTo()方法在比较的时候会忽略了刻度
        BigDecimal bd3 = new BigDecimal("2.0");

        System.out.println(bd1.compareTo(bd3) < 0); // true bd1小于bd3
        System.out.println(bd3.compareTo(bd1) > 0); // true bd3大于bd1
        System.out.println(bd1.compareTo(bd2) == 0); // true bd1等于bd2
        System.out.println(bd1.compareTo(bd3) <= 0); // true bd1小于等于bd3
        System.out.println(bd1.compareTo(bd2) >= 0); // true bd1大于等于bd2
        System.out.println(bd1.compareTo(bd3) != 0); // true


        // equals方法只在两个BigDecimal对象的值和刻度相等时才认为它们相等。
        // 因此，使用此方法比较时，BigDecimals 1.0和1.00是不相等的。
        BigDecimal bd4 = new BigDecimal("1.0");
        BigDecimal bd5 = new BigDecimal("1.00");
        System.out.println(bd4.equals(bd5));
    }
}
