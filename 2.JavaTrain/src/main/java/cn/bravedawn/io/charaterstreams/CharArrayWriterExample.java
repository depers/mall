package cn.bravedawn.io.charaterstreams;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 14:57
 */
public class CharArrayWriterExample {

    /**
     * CharArrayWriter 类可用于将公共数据写入多个文件。此类继承 Writer 类。当数据写入此流时，其缓冲区会自动增长。对此对象调用 close（） 方法不起作用。
     * 将相同的内容写到多个文件中
     */


    public static void main(String[] args) throws IOException {
        CharArrayWriter out = new CharArrayWriter();
        out.write("Welcome to javaTpoint");

        String path = ResourceHelper.getAbsoluteFilePath("doc");
        FileWriter f1 = new FileWriter(path + "/a.txt");
        FileWriter f2 = new FileWriter(path + "/b.txt");
        FileWriter f3 = new FileWriter(path + "/c.txt");
        FileWriter f4 = new FileWriter(path + "/d.txt");
        out.writeTo(f1);
        out.writeTo(f2);
        out.writeTo(f3);
        out.writeTo(f4);
        f1.close();
        f2.close();
        f3.close();
        f4.close();
        System.out.println("Success...");
    }
}
