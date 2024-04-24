package cn.bravedawn.io.bytestream;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-15 11:40
 */
public class DataOutputStreamExample {


    /**
     * DataOutputStream 类允许应用程序以独立于计算机的方式将原始 Java 数据类型写入输出流。比如下面的writeInt()、writeBoolean()等方法
     * Java 应用程序通常使用数据输出流来写入数据，这些数据稍后可以由数据输入流读取。
     */
    public static void main(String[] args) throws IOException {
        FileOutputStream file = new FileOutputStream("E:\\testout.txt");
        DataOutputStream data = new DataOutputStream(file);
        data.writeInt(65);
        data.writeBoolean(true);
        data.writeDouble(1.1);
        data.writeChar('F');

        data.flush();
        data.close();
        System.out.println("Succcess...");
    }
}
