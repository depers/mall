package cn.bravedawn.chapter18.handler.serverhandler;

import cn.bravedawn.chapter18.packet.group.JoinGroupRequestPacket;
import cn.bravedawn.chapter18.packet.group.JoinGroupResponsePacket;
import cn.bravedawn.chapter18.utils.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 15:44
 */
public class JoinGroupRequestHandler extends SimpleChannelInboundHandler<JoinGroupRequestPacket> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupRequestPacket requestPacket) throws Exception {
        String groupId = requestPacket.getGroupId();

        // 1.获取群对应的ChannelGroup，然后将当前用户的Channel添加进去
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        channelGroup.add(ctx.channel());

        // 2.构建加群的响应
        JoinGroupResponsePacket responsePacket = new JoinGroupResponsePacket();
        responsePacket.setSuccess(true);
        responsePacket.setGroupId(groupId);
        ctx.channel().writeAndFlush(responsePacket);
    }
}
