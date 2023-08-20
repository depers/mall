package cn.bravedawn.basic.coreclass.bigdecimal;

import java.math.BigDecimal;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/28 13:15
 */
public class ArithmeticOperations {

    /**
     * BigDecimal算数运算
     * 因为BigDecimal是不可变的，所以这些操作不会修改现有的对象。相反，它们返回新对象
     */

    public static void main(String[] args) {
        BigDecimal bd1 = new BigDecimal("4.0");
        BigDecimal bd2 = new BigDecimal("2.0");

        // 加运算
        BigDecimal sum = bd1.add(bd2);
        // 减运算
        BigDecimal difference = bd1.subtract(bd2);
        // 除运算
        BigDecimal quotient = bd1.divide(bd2);
        // 乘运算
        BigDecimal product = bd1.multiply(bd2);

        System.out.println(sum.compareTo(new BigDecimal("6.0")) == 0); // true
        System.out.println(difference.compareTo(new BigDecimal("2.0")) == 0); // true
        System.out.println(quotient.compareTo(new BigDecimal("2.0")) == 0); // true
        System.out.println(product.compareTo(new BigDecimal("8.0")) == 0); // true
    }
}
