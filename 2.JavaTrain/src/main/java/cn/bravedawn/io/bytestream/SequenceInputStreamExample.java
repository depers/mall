package cn.bravedawn.io.bytestream;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-15 10:45
 */
public class SequenceInputStreamExample {

    /**
     * Java SequenceInputStream 类用于从多个流中读取数据。它按顺序（一个接一个）读取数据。
     *
     * 案例一：打印了两个文件testin.txt和testout.txt的数据
     */


    public static void main(String[] args) throws IOException {
        FileInputStream input1 = new FileInputStream(ResourceHelper.getAbsoluteFilePath("doc/testin.txt"));
        FileInputStream input2 = new FileInputStream(ResourceHelper.getAbsoluteFilePath("doc/testout.txt"));
        SequenceInputStream inst = new SequenceInputStream(input1, input2);
        int j;
        while ((j = inst.read()) != -1) {
            System.out.print((char) j);
        }
        inst.close();
        input1.close();
        input2.close();
    }
}
