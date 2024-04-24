package cn.bravedawn.encrypt.digest.unencrypted;

import org.apache.commons.codec.digest.MurmurHash3;

import java.nio.charset.StandardCharsets;

/**
 * @author : depers
 * @program : 2.JavaTrain
 * @date : Created in 2024/4/19 16:23
 */
public class MurmurHash3Example {

    /**
     * MurmurHash3算法的简单使用
     */

    public static void main(String[] args) {
        System.out.println(MurmurHash3.hash32x86("hello".getBytes(StandardCharsets.UTF_8)));
        System.out.println(MurmurHash3.hash32x86("中国".getBytes(StandardCharsets.UTF_8)));
    }
}
