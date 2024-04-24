package cn.bravedawn.io.charaterstreams;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.File;
import java.io.PrintWriter;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 15:13
 */
public class PrintWriterExample {

    /**
     * 字符打印流
     * PrintWriter 类是 Writer 类的实现。它用于将对象的格式化表示打印到文本输出流。
     * 特点：
     *  1.只能写数据，不能读数据
     *  2.自动刷新功能，PrintWriter(OutputStream out/Writer out,boolean autoflush);第二个参数如果是true 表示启动自动刷新功能
     */

    public static void main(String[] args) throws Exception {
        // Data to write on Console using PrintWriter
        PrintWriter writer = new PrintWriter(System.out);
        writer.write("Javatpoint provides tutorials of all technology.");
        writer.flush();
        writer.close();

        // Data to write in File using PrintWriter
        PrintWriter writer1 = null;
        String path = ResourceHelper.getAbsoluteFilePath("doc/testout.txt");
        writer1 = new PrintWriter(new File(path));
        writer1.write("Like Java, Spring, Hibernate, Android, PHP etc.");
        writer1.flush();
        writer1.close();
    }
}
