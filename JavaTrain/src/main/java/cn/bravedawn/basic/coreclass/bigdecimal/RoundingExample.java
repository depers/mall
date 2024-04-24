package cn.bravedawn.basic.coreclass.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/28 13:26
 */
public class RoundingExample {

    /**
     * 四舍五入
     */

    public static void main(String[] args) {
        BigDecimal quantity = new BigDecimal("4.5");
        BigDecimal unitPrice = new BigDecimal("2.69");
        BigDecimal discountRate = new BigDecimal("0.10");
        BigDecimal taxRate = new BigDecimal("0.0725");

        BigDecimal amountToBePaid = calculateTotalAmount(quantity, unitPrice, discountRate, taxRate);
        System.out.println("11.68".equals(amountToBePaid.toString()));
    }



    public static BigDecimal calculateTotalAmount(BigDecimal quantity,
                                                  BigDecimal unitPrice,
                                                  BigDecimal discountRate,
                                                  BigDecimal taxRate) {
        BigDecimal amount = quantity.multiply(unitPrice);
        System.out.println("amount = " + amount);       // 12.105
        BigDecimal discount = amount.multiply(discountRate);
        System.out.println("discount = " + discount);   // 1.21050
        BigDecimal discountedAmount = amount.subtract(discount);
        System.out.println("discountedAmount = " + discountedAmount); // 10.89450
        BigDecimal tax = discountedAmount.multiply(taxRate);
        System.out.println("tax = " + tax);     // 0.789851250
        BigDecimal total = discountedAmount.add(tax);
        System.out.println("total = " + total); // 11.684351250

        // round to 2 decimal places using HALF_EVEN
        BigDecimal roundedTotal = total.setScale(2, RoundingMode.HALF_EVEN);

        return roundedTotal;
    }

}
