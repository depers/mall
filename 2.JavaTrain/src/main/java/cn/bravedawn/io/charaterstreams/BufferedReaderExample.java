package cn.bravedawn.io.charaterstreams;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 11:49
 */
public class BufferedReaderExample {


    /**
     * BufferedReader 类用于从基于字符的输入流中读取文本。它可用于通过 readLine（） 方法逐行读取数据。它使性能更快。它继承了 Reader 类。
     */

    public static void main(String[] args) throws IOException {
        String path = ResourceHelper.getAbsoluteFilePath("doc/a.txt");
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        int i;
        while ((i = br.read()) != -1) {
            System.out.print((char) i);
        }
        br.close();
        fr.close();
    }
}
