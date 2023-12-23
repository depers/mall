package cn.bravedawn.io.bytestream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-15 16:20
 */
public class FilterOutputStreamExample {

    /**
     *  FilterOutputStream 类实现了 OutputStream 类。它提供了不同的子类，如 BufferedOutputStream 和 DataOutputStream，以提供额外的功能。因此，单独使用较少。
     */


    public static void main(String[] args) throws IOException {
        File data = new File("E:\\testout.txt");
        FileOutputStream file = new FileOutputStream(data);
        FilterOutputStream filter = new FilterOutputStream(file);
        String s = "Welcome to javaTpoint.";
        byte b[] = s.getBytes();
        filter.write(b);
        filter.flush();
        filter.close();
        file.close();
        System.out.println("Success...");
    }
}
