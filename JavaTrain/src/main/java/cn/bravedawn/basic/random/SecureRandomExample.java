package cn.bravedawn.basic.random;

import java.security.SecureRandom;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/25 17:17
 */
public class SecureRandomExample {

    /**
     * 安全敏感的应用程序，我们应该考虑使用SecureRandom。这是一个密码学上的强生成器
     */

    public static void main(String[] args) {
        int min = 0;
        int max = 100;

        SecureRandom secureRandom = new SecureRandom();
        int randomWithSecureRandom = secureRandom.nextInt();
        System.out.println(randomWithSecureRandom);

        int randomWithSecureRandomWithinARange = secureRandom.nextInt(max - min) + min;
        System.out.println(randomWithSecureRandomWithinARange);
    }
}
