package cn.bravedawn.io.charaterstreams;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 15:18
 */
public class OutputStreamWriterExample {

    /**
     * OutputStreamWriter 是一个用于将字符流转换为字节流的类，使用指定的字符集将字符编码为字节。
     * OutputStreamWriter的write()方法会调用编码转换器，将字符转换为字节。然后，生成的字节在写入基础输出流之前会累积在缓冲区中。
     * 传递给 write()方法的字符不会缓冲，我们通过在 BufferedWriter 中使用 OutputStreamWriter 来优化 OutputStreamWriter 的性能，以避免频繁调用转换器。
     */

    public static void main(String[] args) {
        try {
            OutputStream outputStream = new FileOutputStream("output.txt");

            // 将字符变为字节，进行编码转换
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, Charset.defaultCharset());

            // 使用BufferedWriter实现缓冲，提升性能
            BufferedWriter writer = new BufferedWriter(outputStreamWriter);

            writer.write("Hello World~~~");

            writer.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
