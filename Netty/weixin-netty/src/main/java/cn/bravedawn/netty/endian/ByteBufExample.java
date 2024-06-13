package cn.bravedawn.netty.endian;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.EmptyByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/13 10:42
 *
 * 大小端的逻辑
 */
public class ByteBufExample {


    public static byte[] intToByteArray(int value) {
        byte[] bytes = new byte[4];
        bytes[0] = (byte) (value >> 24);
        bytes[1] = (byte) (value >> 16);
        bytes[2] = (byte) (value >> 8);
        bytes[3] = (byte) (value);
        return bytes;
    }

    public static byte[] byteBufToByteArray(int value) {
        // 大端，高位字节放低地址
        ByteBuf buffer = Unpooled.buffer(4);
        buffer.writeInt(value);
        return buffer.array();
    }

    public static byte[] byteBufToByteArrayLE(int value) {
        // 小端，高位字节放高地址
        ByteBuf buffer = Unpooled.buffer(4);
        buffer.writeIntLE(value);
        return buffer.array();
    }

    public static void main(String[] args) {
        System.out.println(Integer.toHexString(10));
        System.out.println(Integer.toBinaryString(10));
        System.out.println(ByteBufUtil.hexDump(intToByteArray(10)));
        System.out.println(ByteBufUtil.hexDump(byteBufToByteArray(10)));
        System.out.println(ByteBufUtil.hexDump(byteBufToByteArrayLE(10)));
    }
}
