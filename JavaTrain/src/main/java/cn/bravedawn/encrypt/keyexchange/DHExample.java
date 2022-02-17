package cn.bravedawn.encrypt.keyexchange;

import java.math.BigInteger;

public class DHExample {

    /**
     * DH算法交换密钥的步骤。假设甲乙双方需要传递密钥，这里的数字传递可以理解为密钥传递
     * https://www.liaoxuefeng.com/wiki/1252599548343744/1304227905273889
     */

    public static void main(String[] args) {

        // 甲方
        BigInteger pow = BigInteger.valueOf(5).pow(123);
        System.out.println(pow.mod(BigInteger.valueOf(509))); // 215

        // 乙方
        BigInteger pow2 = BigInteger.valueOf(5).pow(456);
        System.out.println(pow2.mod(BigInteger.valueOf(509))); // 181

        BigInteger pow3 = BigInteger.valueOf(215).pow(456);
        System.out.println(pow3.mod(BigInteger.valueOf(509))); // 121

        // 甲方
        BigInteger pow4 = BigInteger.valueOf(181).pow(123);
        System.out.println(pow3.mod(BigInteger.valueOf(509))); // 121

    }
}
