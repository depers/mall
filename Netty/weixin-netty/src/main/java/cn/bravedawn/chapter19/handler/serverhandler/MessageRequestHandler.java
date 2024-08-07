package cn.bravedawn.chapter19.handler.serverhandler;

import cn.bravedawn.chapter19.packet.message.MessageRequestPacket;
import cn.bravedawn.chapter19.packet.message.MessageResponsePacket;
import cn.bravedawn.chapter19.utils.Session;
import cn.bravedawn.chapter19.utils.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Chanmoey
 * @date 2022年08月31日
 */
@Slf4j
// 加上注解标识，表明该Handler可以是多个Channel共享的
@ChannelHandler.Sharable
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

    public static final MessageRequestHandler INSTANCE = new MessageRequestHandler();

    protected MessageRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket messageRequestPacket) throws Exception {
        // 获取发送方的会话信息
        Session session = SessionUtil.getSession(ctx.channel());

        // 通过消息发送方的的会话信息构造要发送的消息
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setFromUserId(session.getUserId());
        messageResponsePacket.setFromUserName(session.getUserName());
        messageResponsePacket.setMessage(messageRequestPacket.getMessage());

        // 获得消息接收方的Channel
        Channel toUserChannel = SessionUtil.getChannel(messageRequestPacket.getToUserId());

        // 将消息发送给消息接收方
        if (toUserChannel != null && SessionUtil.hasLogin(toUserChannel)) {
            toUserChannel.writeAndFlush(messageResponsePacket);
        } else {
            log.info("[{}]不在线，发送失败", messageRequestPacket.getToUserId());
        }
    }
}
