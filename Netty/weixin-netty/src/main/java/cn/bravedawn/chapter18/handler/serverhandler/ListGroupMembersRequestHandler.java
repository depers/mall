package cn.bravedawn.chapter18.handler.serverhandler;

import cn.bravedawn.chapter18.packet.group.ListGroupMembersRequestPacket;
import cn.bravedawn.chapter18.packet.group.ListGroupMembersResponsePacket;
import cn.bravedawn.chapter18.utils.Session;
import cn.bravedawn.chapter18.utils.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 15:56
 */
@Slf4j
public class ListGroupMembersRequestHandler extends SimpleChannelInboundHandler<ListGroupMembersRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMembersRequestPacket requestPacket) throws Exception {
        log.info("获取群聊[{}]成员", requestPacket.getGroupId());

        // 获取 channelGroup
        String groupId = requestPacket.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);

        // 遍历成员channel
        List<Session> sessionList = new ArrayList<>();
        for (Channel channel : channelGroup) {
            Session session = SessionUtil.getSession(channel);
            sessionList.add(session);
        }

        // 构建回送对象
        ListGroupMembersResponsePacket responsePacket = new ListGroupMembersResponsePacket();
        responsePacket.setGroupId(groupId);
        responsePacket.setSessionList(sessionList);

        ctx.channel().writeAndFlush(responsePacket);
    }
}
