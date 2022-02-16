package cn.bravedawn.encrypt.hmac;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HmacMD5Example {

    /**
     * 廖雪峰博客中对HamcMd5算法的描述实现
     */


    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
        SecretKey key = keyGen.generateKey();

        // 打印随机生成的key：
        byte[] skey = key.getEncoded();
        System.out.println(skey.length); // 64
        System.out.println(new BigInteger(1, skey).toString(16));

        // Java内置的Mac类，用来执行Hamc操作
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(key);
        mac.update("HelloWorld".getBytes(StandardCharsets.UTF_8));
        byte[] result = mac.doFinal();
        System.out.println(result.length); // 16
        System.out.println(new BigInteger(1, result).toString(16));
    }
}
