package cn.bravedawn.io.bytestream;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-15 11:43
 */
public class DataInputStreamExample {

    /**
     * DataInputStream是一个具有缓冲区的输入流，可以从InputStream中读取基本数据类型（如int、float、double、long等）的数据。
     * 它可以让你以原始数据类型的形式读取输入流中的数据，而不需要进行转换或解析。
     * DataInputStream提供了readByte()、readInt()等方法，可以直接读取基本数据类型，也提供了readFully()方法，可以一次性读取指定长度的字节数组。
     */

    public static void main(String[] args) throws IOException {
        InputStream input = new FileInputStream("E:\\testout.txt");
        DataInputStream inst = new DataInputStream(input);

        int a = inst.readInt();
        boolean b = inst.readBoolean();
        double c = inst.readDouble();
        char d = inst.readChar();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        input.close();
        inst.close();
    }
}
