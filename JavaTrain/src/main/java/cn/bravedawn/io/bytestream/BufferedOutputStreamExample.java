package cn.bravedawn.io.bytestream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-15 10:38
 */
public class BufferedOutputStreamExample {


    /**
     * Java BufferedOutputStream 类用于缓冲输出流。它在内部使用缓冲区来存储数据。它比将数据直接写入流提高了效率。因此，它使性能更快。
     * 若要在 OutputStream 中添加缓冲区，请使用 BufferedOutputStream 类。
     */


    public static void main(String[] args) throws IOException {
        FileOutputStream fout = new FileOutputStream("D:\\testout.txt");
        BufferedOutputStream bout = new BufferedOutputStream(fout);
        String s = "Welcome to javaTpoint.";
        byte b[] = s.getBytes();
        bout.write(b);
        bout.flush();
        bout.close();
        fout.close();
        System.out.println("success");
    }
}
