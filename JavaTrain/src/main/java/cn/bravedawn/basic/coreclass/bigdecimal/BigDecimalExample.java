package cn.bravedawn.basic.coreclass.bigdecimal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/28 10:55
 */
public class BigDecimalExample {

    /**
     * 创建一个BigDecimal
     */

    public static void main(String[] args) {
        BigDecimal bdFromString = new BigDecimal("0.1");
        BigDecimal bdFromCharArray = new BigDecimal(new char[] {'3','.','1','6','1','5'});
        BigDecimal bdlFromInt = new BigDecimal(42);
        BigDecimal bdFromLong = new BigDecimal(123412345678901L);
        BigDecimal bdFromDouble = new BigDecimal(0.1d);
        BigInteger bigInteger = BigInteger.probablePrime(100, new Random());
        BigDecimal bdFromBigInteger = new BigDecimal(bigInteger);
        System.out.println(bdFromString); // 0.1
        System.out.println(bdFromCharArray); // 3.1615
        System.out.println(bdlFromInt); // 42
        System.out.println(bdFromLong); // 123412345678901
        System.out.println(bdFromDouble); // 0.1000000000000000055511151231257827021181583404541015625
        System.out.println(bdFromBigInteger); // 738606027426254493303490638977


        // 将Long和Double使用valueOf()方法转换为BigDecimal。对于Long和Double类型，我们应该有优先使用BigDecimal
        BigDecimal bdFromLong1 = BigDecimal.valueOf(123412345678901L);
        BigDecimal bdFromLong2 = BigDecimal.valueOf(123412345678901L, 2);
        BigDecimal bdFromDouble2 = BigDecimal.valueOf(0.1d);
        System.out.println(bdFromLong1); // 123412345678901
        System.out.println(bdFromLong2); // 1234123456789.01
        System.out.println(bdFromDouble2); // 0.1

    }
}
