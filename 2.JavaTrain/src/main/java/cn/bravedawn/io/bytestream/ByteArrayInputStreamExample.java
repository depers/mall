package cn.bravedawn.io.bytestream;

import java.io.ByteArrayInputStream;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-15 11:35
 */
public class ByteArrayInputStreamExample {


    /**
     * ByteArrayInputStream 由两个词组成：ByteArray 和 InputStream。顾名思义，它可以用来读取字节数组作为输入流。
     *
     * 1、ByteArrayInputStream 类包含一个内部缓冲区，用于将字节数组读取为流。在此流中，数据是从字节数组中读取的。
     * 2、ByteArrayInputStream 的缓冲区会根据数据自动增长。
     */

    public static void main(String[] args) {
        byte[] buf = {35, 36, 37, 38};
        // Create the new byte array input stream
        ByteArrayInputStream byt = new ByteArrayInputStream(buf);
        int k = 0;
        while ((k = byt.read()) != -1) {
            //Conversion of a byte into character
            char ch = (char) k;
            System.out.println("ASCII value of Character is:" + k + "; Special character is: " + ch);
        }
    }
}
