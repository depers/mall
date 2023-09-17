package cn.bravedawn.encrypt.symmetric.des;


import cn.hutool.core.util.HexUtil;
import com.mysql.cj.util.Base64Decoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @author : depers
 * @description : DES加解密
 * @program : 1.spring4.x
 * @date : Created in 2023/9/17 17:02
 */
public class DESUtils {


    private static Key key;
    private static String KEY_STR = "myKey";
    static {
        try {
            KeyGenerator generator = KeyGenerator.getInstance("DES");
            generator.init(new SecureRandom(KEY_STR.getBytes()));
            key = generator.generateKey();
            generator = null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 对str进行DES加密
     *
     * @param str
     * @return
     */
    public static String getEncryptString(String str) {
        Base64.Encoder base64en = Base64.getEncoder();
        try {
            byte[] strBytes = str.getBytes("UTF8");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptStrBytes = cipher.doFinal(strBytes);
            return new String(base64en.encode(encryptStrBytes));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 对str进行DES解密
     *
     * @param str
     * @return
     */
    public static String getDecryptString(String str) {
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            byte[] strBytes = decoder.decode(str);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptStrBytes = cipher.doFinal(strBytes);
            return new String(decryptStrBytes, "UTF8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws Exception {
        String encryptStr = getEncryptString("123");
        System.out.println("加密后的数据:" + encryptStr);
        System.out.println("解密后的数据：" + getDecryptString(encryptStr));
    }
}
