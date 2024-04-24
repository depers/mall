package cn.bravedawn.io.bytestream;

import java.io.*;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-15 16:26
 */
public class FilterInputStreamExample {

    /**
     * FilterInputStream 类实现 InputStream。它包含不同的子类，如 BufferedInputStream、DataInputStream，用于提供附加功能。因此，单独使用较少。
     */

    public static void main(String[] args) throws IOException {
        File data = new File("D:\\testout.txt");
        FileInputStream file = new FileInputStream(data);
        FilterInputStream filter = new BufferedInputStream(file);
        int k = 0;
        while ((k = filter.read()) != -1) {
            System.out.print((char) k);
        }
        file.close();
        filter.close();
    }
}
