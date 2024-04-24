package cn.bravedawn.io.charaterstreams;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 11:40
 */
public class FileWriterExample {

    /**
     * FileWriter 类用于将面向字符的数据写入文件。它是面向字符的类，用于 java 中的文件处理。
     * 与 FileOutputStream 类不同，您不需要将字符串转换为字节数组，因为它提供了直接写入字符串的方法。
     */

    public static void main(String[] args) {
        try {
            String path = ResourceHelper.getAbsoluteFilePath("doc/output.txt");
            FileWriter w = new FileWriter(path);
            String content = "I love my country";
            w.write(content);
            w.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
