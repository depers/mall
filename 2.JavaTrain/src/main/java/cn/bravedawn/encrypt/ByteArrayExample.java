package cn.bravedawn.encrypt;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ByteArrayExample {


    /**
     * 将byte数组转为16进制的字符串
     * 将16进制的字符串转为byte数组
     */

    public static void main(String[] args) {
        String hello = "hello";
        byte[] array = hello.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(array));

        String byteStr = new BigInteger(1, array).toString(16);
        System.out.println(byteStr);

        // 这个地方有问题，后面遇到的时候再改一下
        System.out.println(Arrays.toString(byteStr.getBytes(StandardCharsets.UTF_8)));
    }
}
