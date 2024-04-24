package cn.bravedawn.io.bytestream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-15 10:40
 */
public class BufferedInputStreamExample {

    /**
     * Java BufferedInputStream 类用于从流中读取信息。它内部使用缓冲机制，使性能更快。
     */

    public static void main(String[] args) {

        try {
            FileInputStream fin = new FileInputStream("D:\\testout.txt");
            BufferedInputStream bin = new BufferedInputStream(fin);
            int i;
            while ((i = bin.read()) != -1) {
                System.out.print((char) i);
            }
            bin.close();
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
