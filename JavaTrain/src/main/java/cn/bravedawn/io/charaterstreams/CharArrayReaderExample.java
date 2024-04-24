package cn.bravedawn.io.charaterstreams;

import java.io.CharArrayReader;
import java.io.IOException;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 11:52
 */
public class CharArrayReaderExample {

    /**
     * CharArrayReader 由两个词组成：CharArray 和 Reader。CharArrayReader 类用于将字符数组读取转为读取器（流）。它继承了 Reader 类。
     */

    public static void main(String[] args) throws IOException {
        char[] ary = {'j', 'a', 'v', 'a', 't', 'p', 'o', 'i', 'n', 't'};
        CharArrayReader reader = new CharArrayReader(ary);
        int k = 0;
        // Read until the end of a file
        while ((k = reader.read()) != -1) {
            char ch = (char) k;
            System.out.print(ch + " : ");
            System.out.println(k);
        }
    }
}
