package cn.bravedawn.chapter20.handler.clienthandler;

import cn.bravedawn.chapter20.packet.group.ListGroupMembersResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 16:01
 */
@Slf4j
public class ListGroupMembersResponseHandler extends SimpleChannelInboundHandler<ListGroupMembersResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMembersResponsePacket responsePacket) throws Exception {
        log.info("群[{}]中的人包括：{}", responsePacket.getGroupId(), responsePacket.getSessionList());
    }
}
