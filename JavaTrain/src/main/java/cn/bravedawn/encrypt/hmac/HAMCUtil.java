package cn.bravedawn.encrypt.hmac;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class HAMCUtil {


    /**
     * BaelDung教程中对于 Hamc算法的实现
     * 教程: https://www.baeldung.com/java-hmac
     * Github: https://github.com/eugenp/tutorials/blob/master/core-java-modules/core-java-security-3/src/main/java/com/baeldung/hmac/HMACUtil.java
     */

    public static String hmacWithJava(String algorithm, String data, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), algorithm);
        Mac mac = Mac.getInstance(algorithm);
        mac.init(secretKeySpec);
        return bytesToHex(mac.doFinal(data.getBytes(StandardCharsets.UTF_8)));
    }



    /**
     * 将byte数组转为16进制字符串
     * @param hash
     * @return
     */
    public static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);

        for (byte h : hash) {
            String hex = Integer.toHexString(0xff & h);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }


    /**
     * 将byte数组转为16进制字符串，精简版
     * @param hash
     * @return
     */
    public static String bytesToHexSimplify(byte[] hash) {
        return new BigInteger(1, hash).toString(16);
    }


    public static void main(String[] args) {
        byte[] bytes = "hello".getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes));

        System.out.println(bytesToHex(bytes));
        System.out.println(new BigInteger(1, bytes).toString(16));
    }
}
