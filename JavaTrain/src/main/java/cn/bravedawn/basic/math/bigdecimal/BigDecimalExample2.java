package cn.bravedawn.basic.math.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/15 15:57
 */
public class BigDecimalExample2 {

    /**
     * BigDecimal的3个toString方法
     */

    public static void main(String[] args) {
        BigDecimal bg = new BigDecimal("1E11");
        System.out.println(bg.toEngineeringString());
        System.out.println(bg.toPlainString());
        System.out.println(bg.toString());
    }
}
