package cn.bravedawn.io.charaterstreams;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 11:46
 */
public class BufferedWriterExample {


    /**
     *  BufferedWriter 类用于为 Writer 实例提供缓冲。它使性能更快。它继承了 Writer 类。缓冲字符用于提供单个数组、字符和字符串的高效写入。
     */

    public static void main(String[] args) throws IOException {
        String path = ResourceHelper.getAbsoluteFilePath("doc/output.txt");
        FileWriter writer = new FileWriter(path);
        BufferedWriter buffer = new BufferedWriter(writer);
        buffer.write("Welcome to javaTpoint.");
        buffer.close();
        System.out.println("Success");
    }
}
