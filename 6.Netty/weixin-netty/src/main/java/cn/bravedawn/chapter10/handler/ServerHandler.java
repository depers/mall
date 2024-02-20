package cn.bravedawn.chapter10.handler;

import cn.bravedawn.chapter10.packet.Packet;
import cn.bravedawn.chapter10.packet.PacketCodec;
import cn.bravedawn.chapter10.packet.login.LoginRequestPacket;
import cn.bravedawn.chapter10.packet.login.LoginResponsePacket;
import cn.bravedawn.chapter10.packet.message.MessageRequestPacket;
import cn.bravedawn.chapter10.packet.message.MessageResponsePacket;
import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.log4j.Log4j2;

import java.util.Date;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/2/19 16:12
 */
@Log4j2
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf requestByteBuf = (ByteBuf) msg;

        Packet packet = PacketCodec.INSTANCE.decode(requestByteBuf);

        if (packet instanceof LoginRequestPacket) {
            LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;
            LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
            loginResponsePacket.setVersion(packet.getVersion());
            if (valid(loginRequestPacket)) {
                // 校验成功
                loginResponsePacket.setSuccess(true);
            } else {
                // 校验失败
                loginResponsePacket.setReason("账号或密码校验失败");
                loginResponsePacket.setSuccess(false);
            }
            ByteBuf responseByteBuf = PacketCodec.INSTANCE.encode(ctx.alloc(), loginResponsePacket);
            ctx.channel().writeAndFlush(responseByteBuf);

        } else if (packet instanceof MessageRequestPacket) {
            MessageRequestPacket messageRequestPacket = (MessageRequestPacket) packet;
            // 消息处理
            log.info("{}: 收到客户端消息: {}", new Date(), messageRequestPacket.getMessage());

            MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
            messageResponsePacket.setMessage(
                    new Date() + ": 收到客户端消息: " + messageRequestPacket.getMessage()
            );

            ByteBuf responseByteBuf = PacketCodec.INSTANCE.encode(ctx.alloc(), messageResponsePacket);
            ctx.channel().writeAndFlush(responseByteBuf);
        }


    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        log.info("验证登录信息：{}", JSON.toJSONString(loginRequestPacket));
        return true;
    }
}

