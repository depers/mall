package cn.bravedawn.io.charaterstreams;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 11:11
 */
public class WriterExample {

    /**
     * Writer是一个用于写入字符流的抽象类。大多数子类要覆盖他定义的一些方法，以提供更好的性能和功能
     */

    public static void main(String[] args) {
        try {
            String path = ResourceHelper.getAbsoluteFilePath("doc/output.txt");
            Writer w = new FileWriter(path);
            String content = "I love my country";
            w.write(content);
            w.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
