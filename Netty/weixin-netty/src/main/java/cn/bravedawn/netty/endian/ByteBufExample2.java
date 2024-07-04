package cn.bravedawn.netty.endian;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/21 13:49
 */
public class ByteBufExample2 {

    public static void main(String[] args) {
        String str = "abc";

        byte[] md5Array = DigestUtils.md5(str);
        for (byte b : md5Array) {
            System.out.println("byte: " + b);
            ByteBuf buffer = Unpooled.buffer(4);
            buffer.writeByte(b);
            System.out.println("ByteBuf" + ByteBufUtil.prettyHexDump(buffer));
        }

        ByteBuf buffer = Unpooled.buffer();
        buffer.writeBytes(md5Array);
        System.out.println("ByteBuf" + ByteBufUtil.prettyHexDump(buffer));
    }



}
