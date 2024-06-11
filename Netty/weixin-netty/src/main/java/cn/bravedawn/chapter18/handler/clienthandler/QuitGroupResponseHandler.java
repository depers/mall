package cn.bravedawn.chapter18.handler.clienthandler;

import cn.bravedawn.chapter18.packet.group.QuitGroupResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 15:57
 */
@Slf4j
public class QuitGroupResponseHandler extends SimpleChannelInboundHandler<QuitGroupResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupResponsePacket responsePacket) throws Exception {
        if (responsePacket.isSuccess()) {
            log.info("退出群聊[{}]成功", responsePacket.getGroupId());
        } else {
            log.info("退出群聊[{}]失败", responsePacket.getGroupId());
        }
    }
}