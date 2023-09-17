package cn.bravedawn.encrypt.symmetric.aes;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @author : depers
 * @program : encrypt
 * @description: AES加密
 * @date : Created in 2021/4/21 10:09
 */
public class AESUtil {

    /**
     * 这个工具类不推荐使用
     */

    /**
     * 加密
     * @param content 加密内容
     * @param encryptKey 密钥
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     */
    private static byte[] aesEncryptToBytes(String content, String encryptKey) throws NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        // 1.构造密钥生成器，指定为AES算法,不区分大小写
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        // 2.根据encryptKey初始化密钥生成器，生成一个128位的随机源
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(encryptKey.getBytes());
        keyGenerator.init(128, secureRandom);
        // 3.创建密码器
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyGenerator.generateKey().getEncoded(), "AES"));
        return cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
    }


    /**
     * 解密
     * @param encryptBytes 解密内容
     * @param decryptKey 密钥
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    private static String aesDecryByBytes(byte[] encryptBytes, String decryptKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        // 1.构造密钥生成器，指定为AES算法,不区分大小写
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        // 2.根据encryptKey初始化密钥生成器，生成一个128位的随机源
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(decryptKey.getBytes());
        keyGenerator.init(128, secureRandom);
        // 3.创建密码器
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keyGenerator.generateKey().getEncoded(), "AES"));
        return new String(cipher.doFinal(encryptBytes));
    }

    /**
     * AES加密并做Base64编码
     * @param content
     * @param keyString
     * @return
     * @throws Throwable
     */
    public static String aesEncrypt(String content, String keyString) throws Throwable{
        if (StringUtils.isBlank(content)) {
            throw new IllegalArgumentException("Encrypt content is not blank.");
        }
        if (StringUtils.isBlank(keyString)) {
            throw new IllegalArgumentException("Encrypt keyString is not blank.");
        }

        return Base64.getUrlEncoder().encodeToString(aesEncryptToBytes(content, keyString));
    }

    /**
     * 将Base64编码内容做AES解密
     * @param content 解密内容
     * @param keyString 密钥
     * @return
     * @throws Throwable
     */
    public static String aesDecrypt(String content, String keyString) throws Throwable{
        if (StringUtils.isBlank(content)) {
            throw new IllegalArgumentException("Decrypt content is not blank.");
        }
        if (StringUtils.isBlank(keyString)) {
            throw new IllegalArgumentException("Decrypt keyString is not blank.");
        }

        return aesDecryByBytes(Base64.getUrlDecoder().decode(content), keyString);
    }


    public static void main(String[] args) throws Throwable {
        // 该密钥就为测试环境的密钥
        String key = "QeMk6G1U/pRzZDux";
        String content = "hello world";

        String enStr = aesEncrypt(content, key);
        System.out.println(enStr);
        String deStr = aesDecrypt(enStr, key);
        System.out.println(deStr);

    }
}
