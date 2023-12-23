package cn.bravedawn.io.nio.channel;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-20 17:21
 */
public class FileChannelExample {

    /**
     * 通道
     * Channel和IO流类似，但也有区别：
     * 1.Channel-通道可以读取和写入通道。流通常是单向的（读取或写入）
     * 2.Channel异步读取和写入。
     * 3.Channel始终读取或写入缓冲区。
     */


    public static void main(String[] args) throws IOException {
        String path = ResourceHelper.getAbsoluteFilePath("doc/test.txt");
        RandomAccessFile aFile = new RandomAccessFile(path, "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }

}
