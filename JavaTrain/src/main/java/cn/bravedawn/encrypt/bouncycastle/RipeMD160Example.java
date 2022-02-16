package cn.bravedawn.encrypt.bouncycastle;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

public class RipeMD160Example {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // 注册BouncyCastle
        Security.addProvider(new BouncyCastleProvider());
        // 按算法名称调用
        MessageDigest md = MessageDigest.getInstance("RipeMD160");

        md.update("HelloWorld".getBytes(StandardCharsets.UTF_8));
        byte[] result = md.digest();
        System.out.println(new BigInteger(1, result).toString(16));

    }
}
