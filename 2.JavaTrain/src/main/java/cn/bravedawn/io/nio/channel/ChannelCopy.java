package cn.bravedawn.io.nio.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author : depers
 * @description :
 * @program : 2.JavaTrain
 * @date : Created in 2023/12/31 14:53
 */
public class ChannelCopy {

    /**
     * 使用NIO复制文件的程序，下面的方法并不是最佳实践，transferTo()和transferFrom
     */

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("arguments: sourcefile destfile");
            // 异常终止
            System.exit(1);
        }

        FileChannel in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while (in.read(buffer) != -1) { // 从通道读取数据到缓冲区
            buffer.flip();  // 调用read()方法告知FileChannel向ByteBuffer存储字节后，就必须调用缓冲器的flip()方法，让缓冲器做好让别人读取字节的准备
            out.write(buffer); // 将缓冲区的数据写入到通道
            buffer.clear(); // 清除缓冲区中的数据
        }

    }
}
