package cn.bravedawn.io.bytestream;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.*;
/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-15 10:52
 */
public class SequenceInputStreamExample2 {

    /**
     * 从两个文件读取数据并写入另一个文件
     */
    public static void main(String[] args) throws IOException {
        FileInputStream fin1 = new FileInputStream(ResourceHelper.getAbsoluteFilePath("doc/testin1.txt"));
        FileInputStream fin2 = new FileInputStream(ResourceHelper.getAbsoluteFilePath("doc/testin2.txt"));

        FileOutputStream fout = new FileOutputStream(ResourceHelper.getAbsoluteFilePath("doc/testout.txt"));
        SequenceInputStream sis = new SequenceInputStream(fin1, fin2);
        int i;
        while ((i = sis.read()) != -1) {
            fout.write(i);
        }
        sis.close();
        fout.close();
        fin1.close();
        fin2.close();
        System.out.println("Success..");
    }
}
