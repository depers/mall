package cn.bravedawn.basic.lang.string.charset;


import org.apache.commons.codec.binary.StringUtils;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-11-20 14:20
 */
public class EncodeExample2 {

    /**
     * 将字符串编码为UTF-8
     * 将字符串转化为字节的过程，我们称为 编码。
     * 将字节转化为字符串，我们称为 解码。
     */

    public static void main(String[] args) throws UnsupportedEncodingException {
        encodingWithCoreJava();

        encodingWithJava7StandardCharsets();

        encodingWithCommonsCodec();

        encodingGBK();
    }

    private static void encodingGBK() throws UnsupportedEncodingException {

        String rawString = "中国";

        byte[] bytes = rawString.getBytes("gbk");

        String str = new String(bytes, "gbk");
        System.out.println(str);
    }


    /**
     * 使用 Core Java 进行编码
     */
    static void encodingWithCoreJava() {
        String rawString = "中文123abc";
        // 编码
        byte[] bytes = rawString.getBytes(StandardCharsets.UTF_8);

        // 解码
        String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(StringUtils.equals(rawString, utf8EncodedString));
    }


    /**
     * 使用 Java 7 StandardCharsets 进行编码
     */
    static void encodingWithJava7StandardCharsets() {
        String rawString = "中文123abc";
        ByteBuffer buffer = StandardCharsets.UTF_8.encode(rawString);

        String utf8EncodedString = StandardCharsets.UTF_8.decode(buffer).toString();
        System.out.println(StringUtils.equals(rawString, utf8EncodedString));
    }

    /**
     * 使用 commons-codec 编码
     */
    static void encodingWithCommonsCodec() {
        String rawString = "中文123abc";
        byte[] bytes = StringUtils.getBytesUtf8(rawString);

        String utf8EncodedString = StringUtils.newStringUtf8(bytes);
        System.out.println(StringUtils.equals(rawString, utf8EncodedString));

    }
}
