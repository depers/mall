package cn.bravedawn.encrypt.digest;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Example {

    /**
     * MD5算法示例
     */

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // 从这两个方法中我们可以看到，md5的两个方法
        System.out.println(md5Fun1().equals(md5Fun2()));
    }

    static String md5Fun1() throws NoSuchAlgorithmException {
        // 创建一个MessageDigest实例:
        MessageDigest md = MessageDigest.getInstance("MD5");
        // 反复调用update输入数据:
        md.update("Hello".getBytes(StandardCharsets.UTF_8));
        md.update("World".getBytes(StandardCharsets.UTF_8));
        byte[] result = md.digest();
        String sign = new BigInteger(1, result).toString(16);
        System.out.println(sign);
        return sign;
    }

    static String md5Fun2() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update("HelloWorld".getBytes(StandardCharsets.UTF_8));
        byte[] result = md.digest();
        String sign = new BigInteger(1, result).toString(16);
        System.out.println(sign);
        return sign;
    }
}
