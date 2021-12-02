package cn.bravedawn.encrypt;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author : depers
 * @program : JavaTrain
 * @description: SecureRandom
 * @date : Created in 2021/11/30 18:44
 */
public class SecureRandomExample3 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        SecureRandom defaultRandom = new SecureRandom();
        System.out.println(defaultRandom.getAlgorithm());


    }
}
