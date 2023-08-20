package cn.bravedawn.basic.math.bigdecimal;

import java.math.BigDecimal;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/1/7 11:17
 */
public class BigDecimalExample {

    /**
     * 对于BigDecimal的大小比较：
     * 用equals方法的话会不仅会比较值的大小，还会比较两个对象的精确度；
     * 用compareTo方法则不会比较精确度，只比较数值的大小。
     */

    public static void main(String[] args) {
        System.out.println(new BigDecimal("1.2").equals(new BigDecimal("1.20")));           // false
        System.out.println(new BigDecimal("1.2").compareTo(new BigDecimal("1.20")) == 0);   // true
    }
}
