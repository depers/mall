package cn.bravedawn.io.bytearraystreams;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ByteArrayOutputStreamExample {

    /**
     * ByteArrayOutputStream的演示：写数据到文件中
     *
     * ByteArrayOutputStream是Java中的一个字节数组输出流，可以将数据写入到内存中的字节数组中。它提供了一些方法来操作内部的字节数组，
     * 如写入、读取、清空等。它的主要作用是在内存中创建一个缓冲区，用于暂存数据，然后再将缓冲区中的数据写入到输出流中。
     */


    public static void main(String[] args) {
        String str = "hello world";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);

        URL resource = ByteArrayOutputStreamExample.class.getResource("/");
        String path = resource.getPath() + "/doc/ByteArrayOutputStreamExample.txt";

        try (
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                FileOutputStream fos = new FileOutputStream(path);
        ) {
            baos.write(bytes);
            baos.writeTo(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
