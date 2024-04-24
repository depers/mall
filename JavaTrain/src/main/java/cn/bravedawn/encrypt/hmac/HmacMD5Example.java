package cn.bravedawn.encrypt.hmac;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class HmacMD5Example {

    /**
     * 廖雪峰博客中对HamcMd5算法的描述实现
     */


    public static void main(String[] args) throws Exception {
        version1();
    }


    /**
     * 使用随机生成的key进行摘要计算
     */
    public static void version1() throws Exception{
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
        SecretKey key = keyGen.generateKey();

        // 打印随机生成的key：
        byte[] skey = key.getEncoded();
        System.out.println(skey.length); // 该算法使用key的长度是64字节

        // Java内置的Mac类，用来执行Hamc操作
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(key);
        mac.update("HelloWorld".getBytes(StandardCharsets.UTF_8));
        byte[] result = mac.doFinal();
        System.out.println(result.length); // 16
        // 转为16进制字符串
        System.out.println(new BigInteger(1, result).toString(16));
    }


    /**
     * 使用指定的key进行摘要计算
     */
    public static void version2() throws Exception {
        byte[] hkey = new byte[] { 106, 70, -110, 125, 39, -20, 52, 56, 85, 9, -19, -72, 52, -53, 52, -45, -6, 119, -63,
                30, 20, -83, -28, 77, 98, 109, -32, -76, 121, -106, 0, -74, -107, -114, -45, 104, -104, -8, 2, 121, 6,
                97, -18, -13, -63, -30, -125, -103, -80, -46, 113, -14, 68, 32, -46, 101, -116, -104, -81, -108, 122,
                89, -106, -109 };

        SecretKey key = new SecretKeySpec(hkey, "HmacMD5");
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(key);
        mac.update("HelloWorld".getBytes("UTF-8"));
        byte[] result = mac.doFinal();
        System.out.println(Arrays.toString(result));
        System.out.println(new BigInteger(1, result).toString(16));
    }

}
