package cn.bravedawn.io.nio.buffer;

import java.nio.ByteBuffer;

/**
 * @author : depers
 * @program : 2.JavaTrain
 * @date : Created in 2024/1/20 18:23
 *
 * ByteBuffer支持的基本类型
 */
public class GetData {


    private static final int bsize = 1024;

    public static void main(String[] args) {
        // 默认分配的字节都是0
        ByteBuffer bb = ByteBuffer.allocate(1024);

        int i = 0;
        while (i++ < bb.limit()) {
            if (bb.get() != 0) {
                System.out.println("nonzero");
            }
        }

        System.out.println("i = " + i);
        bb.rewind();
        // 存储和读取一个字符数组
        bb.asCharBuffer().put("fengxiao!");
        char c;
        while ((c = bb.getChar()) != 0) {
            System.out.print(c + " ");
        }
        System.out.println();

        bb.rewind();
        // 存储和读取一个short
        bb.asShortBuffer().put((short) 471142);
        System.out.println(bb.getShort());

        // 存储和读取一个int
        bb.rewind();
        bb.asIntBuffer().put(99471142);
        System.out.println(bb.getInt());

        // 存储和读取一个long
        bb.rewind();
        bb.asLongBuffer().put(99471142);
        System.out.println(bb.getLong());

        // 存储和读取一个float
        bb.rewind();
        bb.asFloatBuffer().put(99471142);
        System.out.println(bb.getFloat());

        // 存储和读取一个double
        bb.rewind();
        bb.asDoubleBuffer().put(99471142);
        System.out.println(bb.getDouble());
    }
}
