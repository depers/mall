package cn.bravedawn.io.nio.buffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * @author : depers
 * @program : 2.JavaTrain
 * @date : Created in 2024/1/20 19:11
 *
 * 通过字节存放模式设置来改变字符中的字节次序
 * ByteBuffer默认是【高位优先】将最重要的字节存放在地址最低的存储器单元
 */
public class Endians {

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));

        bb.rewind();
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));

        bb.rewind();
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));
    }
}
