package cn.bravedawn.io.charaterstreams;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.FileReader;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 11:42
 */
public class FileReaderExample {

    /**
     * FileReader 类用于从文件中读取数据。它以字节格式返回数据，如 FileInputStream 类。
     * 它是面向字符的类，用于 java 中的文件处理。
     */

    public static void main(String args[]) throws Exception {
        String path = ResourceHelper.getAbsoluteFilePath("doc/a.txt");
        FileReader fr = new FileReader(path);
        int i;
        while ((i = fr.read()) != -1)
            System.out.print((char) i);
        fr.close();
    }
}
