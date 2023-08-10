package cn.bravedawn.io.bytearraystreams;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayInputStreamExample {


    /**
     * ByteArrayInputStream的演示
     * 可以将本地文件的数据读取到内存中，让程序直接从内存中获取数据
     */

    public static void main(String[] args) {
        String fileName = ResourceHelper.getAbsoluteFilePath("doc/test.txt");

        try (
                InputStream inputStream = new FileInputStream(fileName);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputStream.readAllBytes())
        ) {
            int n;
            StringBuilder sb = new StringBuilder();
            while ((n = byteArrayInputStream.read()) != -1) {
                sb.append((char)n);
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
