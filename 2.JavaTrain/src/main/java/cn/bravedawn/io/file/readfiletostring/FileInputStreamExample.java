package cn.bravedawn.io.file.readfiletostring;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/3 14:17
 */
public class FileInputStreamExample {

    /**
     * 使用FileInputStream在Java中将文件读取为String
     * 使用此方法读取非基于字符的文件
     */
    public static void main(String[] args) throws IOException {
        File file = new File(Thread.currentThread().getContextClassLoader().getResource("doc/test.txt").getPath());
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[10];
        StringBuilder sb = new StringBuilder();
        while (fis.read(buffer) != -1) {
            sb.append(new String(buffer));
            buffer = new byte[10];
        }
        fis.close();

        String content = sb.toString();
        System.out.println(content);
    }
}
