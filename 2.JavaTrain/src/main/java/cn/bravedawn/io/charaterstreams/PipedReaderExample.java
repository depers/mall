package cn.bravedawn.io.charaterstreams;

import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 16:00
 */
public class PipedReaderExample {

    /**
     * PipedReader 类用于将管道的内容读取为字符流。此类通常用于读取文本。
     * PipedReader 类必须连接到同一个 PipedWriter，并由不同的线程使用。
     */


    public static void main(String[] args) {
        try {

            final PipedReader read = new PipedReader();
            final PipedWriter write = new PipedWriter(read);

            Thread readerThread = new Thread(new Runnable() {
                public void run() {
                    try {
                        int data = read.read();
                        while (data != -1) {
                            System.out.print((char) data);
                            data = read.read();
                        }
                    } catch (Exception ex) {
                    }
                }
            });

            Thread writerThread = new Thread(new Runnable() {
                public void run() {
                    try {
                        write.write("I love my country\n".toCharArray());
                    } catch (Exception ex) {
                    }
                }
            });

            readerThread.start();
            writerThread.start();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
