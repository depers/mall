package cn.bravedawn.io.bytestream;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 15:07
 */
public class PrintStreamExample {

    /**
     * 字节打印流
     * PrintStream 类提供将数据写入另一个流的方法。PrintStream 类会自动刷新数据，因此无需调用 flush（） 方法。此外，它的方法不会引发 IOException。
     */

    public static void main(String[] args) throws IOException {
        String path = ResourceHelper.getAbsoluteFilePath("doc/testout.txt");
        FileOutputStream fout = new FileOutputStream(path);
        PrintStream pout = new PrintStream(fout);
        pout.println(2016);
        pout.println("Hello Java");
        pout.println("Welcome to Java");
        pout.close();
        fout.close();
        System.out.println("Success?");
    }
}
