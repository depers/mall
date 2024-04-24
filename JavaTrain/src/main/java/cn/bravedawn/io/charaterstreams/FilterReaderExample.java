package cn.bravedawn.io.charaterstreams;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 16:14
 */
public class FilterReaderExample {

    /**
     * FilterReader 用于对读取器流执行过滤操作。它是一个抽象类，用于读取过滤后的字符流。
     * FilterReader 提供将所有请求传递到包含的流的默认方法。FilterReader 的子类应重写其某些方法，还可以提供其他方法和字段。
     */

    static class CustomFilterReader extends FilterReader {
        CustomFilterReader(Reader in) {
            super(in);
        }

        public int read() throws IOException {
            int x = super.read();
            if ((char) x == ' ')
                return ((int) '?');
            else
                return x;
        }
    }

    public static void main(String[] args) {
        try {
            String path = ResourceHelper.getAbsoluteFilePath("doc/input.txt");
            Reader reader = new FileReader(path);
            CustomFilterReader fr = new CustomFilterReader(reader);
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
            fr.close();
            reader.close();
        } catch (Exception e) {
            e.getMessage();
        }

    }
}
