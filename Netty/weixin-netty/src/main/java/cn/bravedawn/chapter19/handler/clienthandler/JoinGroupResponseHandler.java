package cn.bravedawn.chapter19.handler.clienthandler;

import cn.bravedawn.chapter19.packet.group.JoinGroupResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 15:57
 */
@Slf4j
public class JoinGroupResponseHandler extends SimpleChannelInboundHandler<JoinGroupResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupResponsePacket responsePacket) throws Exception {
        if (responsePacket.isSuccess()) {
            log.info("加入群[{}]成功", responsePacket.getGroupId());
        } else {
            log.info("加入群[{}]失败", responsePacket.getGroupId());
        }
    }
}
