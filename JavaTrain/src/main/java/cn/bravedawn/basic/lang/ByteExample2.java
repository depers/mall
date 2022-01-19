package cn.bravedawn.basic.lang;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ByteExample2 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String a = "冯晓1";
        System.out.println(Arrays.toString(a.getBytes(StandardCharsets.UTF_8)));
        System.out.println(Arrays.toString(a.getBytes("GBK")));

    }
}
