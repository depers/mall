package cn.bravedawn.io.nio.buffer;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @author : depers
 * @program : 2.JavaTrain
 * @date : Created in 2024/1/20 18:40
 *
 * 对缓存区中的数据进行修改
 */
public class IntBufferDemo {

    private static final int BSIZE = 1024;


    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();

        // 存储一个int类型的数组
        ib.put(new int[] {11, 42, 47, 99, 143, 811, 1016});
        System.out.println(ib.get(3));
        ib.put(3, 1811);

        // 修改之后记得翻转
        ib.flip();
        while (ib.hasRemaining()) {
            int i = ib.get();
            System.out.println(i);
        }
    }
}
