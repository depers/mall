package cn.bravedawn.chapter6.client.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.log4j.Log4j2;

import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/2/19 14:58
 */
@Log4j2
public class FirstClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * 该方法会在客户端连接建立成功之后被调用
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("{}: 客户端写出数据", new Date());

        // 1. 获取数据
        ByteBuf buffer = getByteBuf(ctx);

        // 2. 写数据
        ctx.channel().writeAndFlush(buffer);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf buffer = (ByteBuf) msg;
        log.info("{}: 客户端读到数据 -> {}", new Date(), buffer.toString(StandardCharsets.UTF_8));
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        // 1. 获取二进制抽象 ByteBuf
        ByteBuf buffer = ctx.alloc().buffer();

        // 2. 准备数据，指定字符串字符集为 UTF-8
        byte[] bytes = "Hello, World".getBytes(StandardCharsets.UTF_8);

        // 3. 填充数据到 ByteBuf
        buffer.writeBytes(bytes);

        return buffer;
    }
}
