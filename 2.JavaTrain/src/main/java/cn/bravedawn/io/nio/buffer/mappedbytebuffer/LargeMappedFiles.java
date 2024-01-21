package cn.bravedawn.io.nio.buffer.mappedbytebuffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author : depers
 * @program : 2.JavaTrain
 * @date : Created in 2024/1/20 20:11
 *
 * 内存映射文件，简单的写入和读取
 */
public class LargeMappedFiles {

    static int length = 0x8ffffff;

    public static void main(String[] args) throws IOException {
        MappedByteBuffer out = new RandomAccessFile("test.dat", "rw")
                .getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++) {
            out.put((byte) 'x');
        }
        System.out.println("Finished writing");

        for (int i = length/2; i < length/2 + 6; i++) {
            System.out.print(out.get(i));
        }
    }
}
