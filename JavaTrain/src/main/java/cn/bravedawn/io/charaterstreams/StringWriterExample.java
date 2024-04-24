package cn.bravedawn.io.charaterstreams;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.*;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 15:46
 */
public class StringWriterExample {

    /**
     * StringWriter 类是一个字符流，它从字符串缓冲区收集输出，可用于构造字符串。
     * StringWriter 类继承 Writer 类。
     * 在 StringWriter 类中，不使用网络套接字和文件等系统资源，因此不需要关闭 StringWriter。
     */

    public static void main(String[] args) throws IOException {
        String path = ResourceHelper.getAbsoluteFilePath("doc");
        char[] ary = new char[512];
        StringWriter writer = new StringWriter();
        FileInputStream input = null;
        BufferedReader buffer = null;
        input = new FileInputStream(path + "/testout.txt");
        buffer = new BufferedReader(new InputStreamReader(input, "UTF-8"));
        int x;
        while ((x = buffer.read(ary)) != -1) {
            writer.write(ary, 0, x);
        }
        System.out.println(writer.toString());
        writer.close();
        buffer.close();
    }
}
