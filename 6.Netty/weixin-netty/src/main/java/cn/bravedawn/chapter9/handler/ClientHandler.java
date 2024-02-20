package cn.bravedawn.chapter9.handler;

import cn.bravedawn.chapter9.packet.Packet;
import cn.bravedawn.chapter9.packet.PacketCodec;
import cn.bravedawn.chapter9.packet.login.LoginRequestPacket;
import cn.bravedawn.chapter9.packet.login.LoginResponsePacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.log4j.Log4j2;

import java.util.Date;
import java.util.UUID;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/2/19 16:01
 */
@Log4j2
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        // 创建登录对象
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUsername("Leslie");
        loginRequestPacket.setPassword("pwd");

        // 编码
        ByteBuf buffer = PacketCodec.INSTANCE.encode(ctx.alloc(), loginRequestPacket);

        log.info("客户端开始登录");
        // 写数据
        ctx.channel().writeAndFlush(buffer);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;

        Packet packet = PacketCodec.INSTANCE.decode(byteBuf);

        if (packet instanceof LoginResponsePacket) {
            LoginResponsePacket loginResponsePacket = (LoginResponsePacket) packet;
            if (loginResponsePacket.isSuccess()) {
                log.info("{}: 客户端登录成功", new Date());
            } else {
                log.info("{}: 客户端登录失败, 失败原因: {}", new Date(), loginResponsePacket.getReason());
            }
        }
    }
}
