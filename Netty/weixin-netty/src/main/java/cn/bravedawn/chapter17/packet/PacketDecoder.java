package cn.bravedawn.chapter17.packet;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/2/22 11:24
 *
 * 统一的解码操作，将二进制数据转为Java对象
 */
public class PacketDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        out.add(PacketCodec.INSTANCE.decode(in));
    }
}
