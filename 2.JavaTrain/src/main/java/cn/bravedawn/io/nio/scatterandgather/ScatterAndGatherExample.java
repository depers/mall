package cn.bravedawn.io.nio.scatterandgather;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/**
 * @author : depers
 * @description :
 * @program : 2.JavaTrain
 * @date : Created in 2023/12/23 14:47
 */
public class ScatterAndGatherExample {


    /**
     * 分散读取和聚集写入的案例
     */

    private static final String path = ResourceHelper.getAbsoluteFilePath("doc/test.txt");

    public static void main(String[] args) {
        String data = "Scattering and Gathering example shown in javatpoint.com";
        gatherBytes(data);
        scatterBytes();
    }


    /**
     * 聚集写入
     * gatherBytes() is used for reading the bytes from the buffers and write it to a file channel.
     * 从多个缓冲区读入字节，然后写入到一个文件通道中
     */
    public static void gatherBytes(String data) {
        // The First Buffer is used for holding a random number
        ByteBuffer buffer1 = ByteBuffer.allocate(8);
        // The Second Buffer is used for holding a data that we want to write
        ByteBuffer buffer2 = ByteBuffer.allocate(400);
        buffer1.asIntBuffer().put(420);
        buffer2.asCharBuffer().put(data);
        GatheringByteChannel gatherer = createChannelInstance(path, true);
        // Write the data into file
        try {
            gatherer.write(new ByteBuffer[]{buffer1, buffer2});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 分散读取
     * scatterBytes() is used for reading the bytes from a file channel into a set of buffers.
     * 从一个文件通道中，将数据读取到多个缓冲区中
     */
    public static void scatterBytes() {
        // The First Buffer is used for holding a random number
        ByteBuffer buffer1 = ByteBuffer.allocate(8);
        // The Second Buffer is used for holding a data that we want to write
        ByteBuffer buffer2 = ByteBuffer.allocate(400);
        ScatteringByteChannel scatter = createChannelInstance(path, false);
        // Reading a data from the channel
        try {
            scatter.read(new ByteBuffer[]{buffer1, buffer2});
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Read the two buffers seperately
        buffer1.rewind();
        buffer2.rewind();

        int bufferOne = buffer1.asIntBuffer().get();
        String bufferTwo = buffer2.asCharBuffer().toString();
        // Verification of content
        System.out.println(bufferOne);
        System.out.println(bufferTwo);
    }


    public static FileChannel createChannelInstance(String file, boolean isOutput) {
        FileChannel FChannel = null;
        try {
            if (isOutput) {
                FChannel = new FileOutputStream(file).getChannel();
            } else {
                FChannel = new FileInputStream(file).getChannel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FChannel;
    }
}
