package cn.bravedawn.encrypt.symmetric.aes;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class AESExample4 {

    /**
     * 基于密码的AES加解密方法，IV同密文一同返回，使用System.arraycopy实现数组复制
     */

    public static final String SALT = "dc0cc7e01d964d82864a5435bdf7250a";
    public static final int KEY_SIZE = 128;

    /**
     * 加密
     * @param plainText
     * @param key
     * @param iv
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static String encryptPasswordBased(String plainText, SecretKey key, IvParameterSpec iv)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] encryptData = join(iv.getIV(), cipher.doFinal(plainText.getBytes()));
        return Base64.getUrlEncoder().encodeToString(encryptData);
    }


    /**
     * 解密
     * @param cipherText
     * @param key
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static String decryptPasswordBased(String cipherText, SecretKey key)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        byte[] decodeData = Base64.getUrlDecoder().decode(cipherText);
        byte[] iv = new byte[16];
        byte[] data = new byte[decodeData.length - 16];
        System.arraycopy(decodeData, 0, iv, 0, 16);
        System.arraycopy(decodeData, 16, data, 0, data.length);
        IvParameterSpec ivps = new IvParameterSpec(iv);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, key, ivps);
        return new String(cipher.doFinal(data));
    }


    /**
     * 获取随机值
     * @return
     */
    public static IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        // 生成用户指定数量的随机字节，随机字节会填充到这个数组中
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }


    /**
     * 从密码中获取密钥
     * @param password 密码
     * @param salt 盐值
     * @param keySize 密钥长度
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static SecretKey getKeyFromPassword(String password, String salt, int keySize)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, keySize);
        SecretKey secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
        return secret;
    }


    /**
     * 合并数据
     * @param bs1 iv
     * @param bs2 encrypt array
     * @return
     */
    private static byte[] join(byte[] bs1, byte[] bs2) {
        byte[] r = new byte[bs1.length + bs2.length];
        System.arraycopy(bs1, 0, r, 0, bs1.length);
        System.arraycopy(bs2, 0, r, bs1.length, bs2.length);
        return r;
    }


    public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        String plainText = "hello world";
        String password = "QeMk6G1U/pRzZDux";
        IvParameterSpec ivParameterSpec = generateIv();
        SecretKey key = getKeyFromPassword(password, SALT, KEY_SIZE);

        String cipherText = encryptPasswordBased(plainText, key, ivParameterSpec);
        String decryptedCipherText = decryptPasswordBased(cipherText, key);

        System.out.println(cipherText);

        System.out.println(plainText.equals(decryptedCipherText));
    }

}
