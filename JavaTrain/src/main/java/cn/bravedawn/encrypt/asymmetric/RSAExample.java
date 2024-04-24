package cn.bravedawn.encrypt.asymmetric;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSAExample {

    /**
     * RSA算法的实现与交互使用
     */

    private String name;
    private PrivateKey privateKey;
    private PublicKey publicKey;


    public RSAExample(String name) throws NoSuchAlgorithmException {
        this.name = name;

        // 生成公私钥
        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
        kpGen.initialize(1024);
        KeyPair kp = kpGen.generateKeyPair();
        this.privateKey = kp.getPrivate();
        this.publicKey = kp.getPublic();
    }


    // 用公钥加密
    public byte[] encrypt(byte[] message, byte[] publicKeyData) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKeyData));
        return cipher.doFinal(message);
    }


    // 用私钥解密
    public byte[] decrypt(byte[] input) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, this.privateKey);
        return cipher.doFinal(input);
    }

    // 恢复公钥
    public PublicKey getPublicKey(byte[] publicData) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory kf = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicData);
        return kf.generatePublic(keySpec);
    }


    // 恢复私钥
    public PrivateKey getPrivateKey(byte[] privateData) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateData);
        return kf.generatePrivate(keySpec);
    }

    private static String encryptBASE64(byte[] encoded) {
        return Base64.getEncoder().encodeToString(encoded);
    }


    private static byte[] decryptBASE64(String key) {
        return Base64.getDecoder().decode(key);

    }


    public String getPublicKey() {
        return encryptBASE64(this.publicKey.getEncoded());
    }



    public static void main(String[] args) throws Exception{
        RSAExample xiaoming = new RSAExample("小明");
        RSAExample xiaohong = new RSAExample("小红");

        String message = "hello world";
        System.out.println("小红的公钥：" + xiaohong.getPublicKey());
        byte[] encrypt = xiaoming.encrypt(message.getBytes(StandardCharsets.UTF_8), decryptBASE64(xiaohong.getPublicKey()));
        System.out.println("小明使用小红公钥加密后的数据：" + encryptBASE64(encrypt));

        byte[] decrypt = xiaohong.decrypt(encrypt);
        System.out.println("小红私钥解密后的数据：" + new String(decrypt));
    }

}
