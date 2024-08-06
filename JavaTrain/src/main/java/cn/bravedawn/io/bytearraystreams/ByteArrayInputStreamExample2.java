package cn.bravedawn.io.bytearraystreams;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/8/3 16:13
 */
public class ByteArrayInputStreamExample2 {

    public static void main(String[] args) {

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("hello".getBytes());

        System.out.println(byteArrayInputStream.available());
        System.out.println(byteArrayInputStream.markSupported());
        System.out.println(Arrays.toString(byteArrayInputStream.readAllBytes()));
        System.out.println(byteArrayInputStream.available());

        byteArrayInputStream.mark(1);
        byteArrayInputStream.reset();
        System.out.println(Arrays.toString(byteArrayInputStream.readAllBytes()));
    }
}
