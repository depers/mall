package cn.bravedawn.io.bytestream;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 16:45
 */
public class PipedInputStreamExample {

    /**
     * 下面演示了PipedInputStream和PipedOutputStream的使用方法
     * 通过下面的实验可以发现，用法和PipedReader和PipedWriter类似
     * 可以通过管道实现线程之间的通信
     */

    public static void main(String[] args) {
        try {
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

            Thread writerThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while(true) {
                            String data = "hello xian";
                            pipedOutputStream.write(data.getBytes());
                            pipedOutputStream.flush();
                            System.out.println("write ok");
                            Thread.sleep(1000);
                        }

                    } catch (Throwable e) {
                        e.printStackTrace();
                    }

                }
            });


            Thread readerThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        byte[] data = new byte[10];
                        while (true) {
                            pipedInputStream.read(data);
                            System.out.println(new String(data));
                            System.out.println("read ok-------");
                            Thread.sleep(1000);
                        }

                    } catch (Throwable e) {
                        e.printStackTrace();
                    }

                }
            });

            readerThread.start();
            writerThread.start();

        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }
}
