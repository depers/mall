package cn.bravedawn.encrypt;


import sun.security.jca.Providers;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @description: SecureRandom
 * @date : Created in 2021/11/30 18:44
 */
public class SecureRandomExample2 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        SecureRandom secureRandom1 = new SecureRandom();
        SecureRandom secureRandom2 = new SecureRandom();

        secureRandom1.setSeed(123);
        secureRandom2.setSeed(123);

        System.out.println(secureRandom1.nextDouble());
        System.out.println(secureRandom2.nextDouble());

    }
}
