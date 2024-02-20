package cn.bravedawn.basic.lang;

import cn.bravedawn.obj.inherit.lsp.meaning1.B;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author : depers
 * @program : 2.JavaTrain
 * @date : Created in 2024/2/18 11:21
 */
public class DoubleExample {


    /**
     * 在int的除法运算中，如果存在除不尽的情况下，我们需要查看小数点的话，需要强置将其类型转换为double
     */

    public static void main(String[] args) {
        double a = 5;
        double b = 2;
        int c = 10;
        int d = 3;
        System.out.println(a / b);
        System.out.println((double) c / d);

    }
}
