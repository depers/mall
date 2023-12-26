package cn.bravedawn.io.nio.datatransfer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-21 11:26
 */
public class ChannelTransferExample {


    /**
     * 通道间数据的传输，transferFrom()和transferTo()的区别就在于调用的对象不同
     */

    public static void main(String[] args) throws IOException {

        RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();

        // transferFrom()
        toChannel.transferFrom(fromChannel, position, count);


        // transferTo()
        fromChannel.transferTo(position, count, toChannel);
    }
}
