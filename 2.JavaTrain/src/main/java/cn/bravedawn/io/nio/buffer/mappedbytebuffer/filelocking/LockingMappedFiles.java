package cn.bravedawn.io.nio.buffer.mappedbytebuffer.filelocking;

import cn.bravedawn.basic.keyword.static_.inherit.People;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author : depers
 * @program : 2.JavaTrain
 * @date : Created in 2024/1/21 17:09
 *
 * 对映射文件的部分内容进行加锁
 */
public class LockingMappedFiles {

    static final int LENGTH = 0x8FFFFFF; // 128mb
    static FileChannel fc;


    public static void main(String[] args) throws Exception {
        fc = new RandomAccessFile("test.dat", "rw").getChannel();
        MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            out.put((byte) 'x');
        }

        new LockAndModify(out, 0, 0 + LENGTH / 3);
        new LockAndModify(out, LENGTH / 2, LENGTH / 2 + LENGTH / 4);

    }


    private static class LockAndModify extends Thread {

        private ByteBuffer buffer;
        private int start, end;

        LockAndModify(ByteBuffer mbb, int start, int end) {
            this.buffer = mbb;
            this.start = start;
            this.end = end;
            mbb.limit(end);
            mbb.position(start);
            // 按照start和end对buffer进行切分
            buffer = mbb.slice();
            start();
        }

        @Override
        public void run() {
            try {
                FileLock fl = fc.lock(start, end, false);
                System.out.println("Locked: " + start + " to " + end);
                while (buffer.position() < buffer.limit() - 1) {
                    buffer.put((byte) (buffer.get() + 1));
                }
                fl.release();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
