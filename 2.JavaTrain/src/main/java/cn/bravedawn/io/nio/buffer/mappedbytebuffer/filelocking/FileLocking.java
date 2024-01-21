package cn.bravedawn.io.nio.buffer.mappedbytebuffer.filelocking;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * @author : depers
 * @program : 2.JavaTrain
 * @date : Created in 2024/1/20 21:08
 *
 * 对文件进行加锁
 */
public class FileLocking {


    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fos = new FileOutputStream("file.txt");
        FileLock fileLock = fos.getChannel().tryLock();
        if (fileLock != null) {
            System.out.println("Locked File");
            TimeUnit.MICROSECONDS.sleep(100);
            fileLock.release();
            System.out.println("Released Lock");
        }
        fos.close();
    }
}
