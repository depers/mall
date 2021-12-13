package cn.bravedawn.encrypt.symmetric;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2021/12/12 16:28
 */
public class AESExample {


    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    }
}
