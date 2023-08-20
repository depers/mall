package cn.bravedawn.basic.coreclass.bigdecimal;

import java.math.BigDecimal;

public class BigDecimalExample4 {

    /**
     * BigDecimal的相关方法的使用
     * @param args
     */

    public static void main(String[] args) {

        // 测试stripTrailingZeros()方法
        testStripTrailingZeros();


    }


    private static void testStripTrailingZeros() {
        // stripTrailingZeros()该方法的返回类型为BigDecimal ，它返回一个与该BigDecimal相似的BigDecimal，但没有任何尾随零
        BigDecimal b1 = new BigDecimal(1.20);
        BigDecimal b2 = new BigDecimal(1.00);
        BigDecimal b3 = new BigDecimal(12300);
        BigDecimal b4 = new BigDecimal(-12300);

        System.out.println(b1.stripTrailingZeros());
        System.out.println(b2.stripTrailingZeros());
        System.out.println(b3.stripTrailingZeros());
        System.out.println(b4.stripTrailingZeros());
    }
}
