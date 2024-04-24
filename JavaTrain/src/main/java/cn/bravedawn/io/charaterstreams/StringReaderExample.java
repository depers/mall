package cn.bravedawn.io.charaterstreams;

import java.io.IOException;
import java.io.StringReader;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 15:53
 */
public class StringReaderExample {


    /**
     * StringReader 类是以字符串为源的字符流。它接受一个输入字符串并将其更改为字符流。它继承了 Reader 类。
     * 在 StringReader 类中，不使用网络套接字和文件等系统资源，因此不需要关闭 StringReader。
     */

    public static void main(String[] args) throws IOException {
        String srg = "Hello Java!! \nWelcome to Javatpoint.";
        StringReader reader = new StringReader(srg);
        int k = 0;
        while ((k = reader.read()) != -1) {
            System.out.print((char) k);
        }
    }
}
