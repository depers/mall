package cn.bravedawn.io.bytestream;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-15 11:29
 */
public class ByteArrayOutputStreamExample {


    /**
     *  ByteArrayOutputStream 类用于将公共数据写入多个文件。在此流中，数据被写入字节数组，稍后可以写入多个流。
     *  1、ByteArrayOutputStream 保存数据的副本并将其转发到多个流。
     *  2、ByteArrayOutputStream 的缓冲区会根据数据自动增长。
     */

    public static void main(String[] args) throws IOException {
        FileOutputStream fout1 = new FileOutputStream("D:\\f1.txt");
        FileOutputStream fout2 = new FileOutputStream("D:\\f2.txt");

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        bout.write(65);
        bout.writeTo(fout1);
        bout.writeTo(fout2);

        bout.flush();
        bout.close();//has no effect
        System.out.println("Success...");
    }

}
