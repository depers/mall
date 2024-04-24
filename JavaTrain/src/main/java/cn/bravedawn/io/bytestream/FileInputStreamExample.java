package cn.bravedawn.io.bytestream;

import java.io.FileInputStream;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-15 10:33
 */
public class FileInputStreamExample {

    /**
     * FileInputStream 类从文件中获取输入字节。它用于读取面向字节的数据（原始字节流），如图像数据、音频、视频等。您还可以读取字符流数据。
     * 但是，对于读取字符流，建议使用 FileReader 类。
     */

    public static void main(String[] args) {

        readSingleChar();

        readAllChars();
    }

    private static void readSingleChar() {
        try {
            FileInputStream fin = new FileInputStream("E:\\testout.txt");
            int i = fin.read();
            System.out.println((char) i);

            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    private static void readAllChars() {
        try {
            FileInputStream fin = new FileInputStream("E:\\testout.txt");
            int i = 0;
            while ((i = fin.read()) != -1) {
                System.out.print((char) i);
            }
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
