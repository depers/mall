package cn.bravedawn.encrypt;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author : depers
 * @program : JavaTrain
 * @description: SecureRandom
 * @date : Created in 2021/11/30 18:44
 */
public class SecureRandomExample2 {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        System.out.println("-------------------------------" + new SecureRandom().getAlgorithm());
        SecureRandom secureRandom1 = new SecureRandom();
        SecureRandom secureRandom2 = new SecureRandom();

        secureRandom1.setSeed(123);
        secureRandom2.setSeed(123);

        System.out.println(secureRandom1.nextLong());
        System.out.println(secureRandom2.nextLong());

        System.out.println("-------------------------------" + SecureRandom.getInstance("SHA1PRNG").getAlgorithm());
        SecureRandom secureRandom3 = SecureRandom.getInstance("SHA1PRNG");
        SecureRandom secureRandom4 = SecureRandom.getInstance("SHA1PRNG");

        secureRandom3.setSeed(123);
        secureRandom4.setSeed(123);

        System.out.println(secureRandom3.nextLong());
        System.out.println(secureRandom4.nextLong());

        //System.out.println("-------------------------------" + SecureRandom.getInstance("NativePRNGNonBlocking").getAlgorithm());
        //SecureRandom secureRandom5 = SecureRandom.getInstance("NativePRNGNonBlocking");
        //SecureRandom secureRandom6 = SecureRandom.getInstance("NativePRNGNonBlocking");
        //
        //secureRandom5.setSeed(123);
        //secureRandom6.setSeed(123);
        //
        //System.out.println(secureRandom5.nextLong());
        //System.out.println(secureRandom6.nextLong());

    }
}
