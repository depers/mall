package cn.bravedawn.io.charaterstreams;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.FileReader;
import java.io.Reader;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 11:34
 */
public class ReaderExample {

    /**
     * Reader 是一个用于读取字符流的抽象类。大多数子类覆盖某些方法以提供更好的性能和功能
     */


    public static void main(String[] args) {
        try {

            String path = ResourceHelper.getAbsoluteFilePath("doc/a.txt");
            Reader reader = new FileReader(path);
            int data = reader.read();
            while (data != -1) {
                System.out.print((char) data);
                data = reader.read();
            }
            reader.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}