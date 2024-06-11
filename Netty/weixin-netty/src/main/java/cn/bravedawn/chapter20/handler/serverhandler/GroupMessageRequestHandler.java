package cn.bravedawn.chapter20.handler.serverhandler;

import cn.bravedawn.chapter20.packet.group.GroupMessageRequestPacket;
import cn.bravedawn.chapter20.packet.group.GroupMessageResponsePacket;
import cn.bravedawn.chapter20.utils.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 16:33
 */
public class GroupMessageRequestHandler extends SimpleChannelInboundHandler<GroupMessageRequestPacket> {

    public static final GroupMessageRequestHandler INSTANCE = new GroupMessageRequestHandler();

    protected GroupMessageRequestHandler() {

    }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageRequestPacket requestPacket) throws Exception {
        String groupId = requestPacket.getGroupId();

        GroupMessageResponsePacket responsePacket = new GroupMessageResponsePacket();
        responsePacket.setFromGroupId(groupId);
        responsePacket.setMessage(requestPacket.getMessage());
        responsePacket.setFromUser(SessionUtil.getSession(ctx.channel()));

        // 获取 channelGroup
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        channelGroup.writeAndFlush(responsePacket);
    }
}

