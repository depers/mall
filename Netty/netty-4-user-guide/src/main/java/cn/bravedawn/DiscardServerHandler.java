package cn.bravedawn;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author : depers
 * @program : netty-4-user-guide
 * @date : Created in 2024/1/20 17:45
 *
 * 处理服务端 channel
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 默默的丢弃收到的数据
        ((ByteBuf) msg).release();
    }
}
