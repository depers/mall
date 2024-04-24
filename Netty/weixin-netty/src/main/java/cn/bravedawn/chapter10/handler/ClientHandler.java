package cn.bravedawn.chapter10.handler;

import cn.bravedawn.chapter10.packet.Packet;
import cn.bravedawn.chapter10.packet.PacketCodec;
import cn.bravedawn.chapter10.packet.login.LoginRequestPacket;
import cn.bravedawn.chapter10.packet.login.LoginResponsePacket;
import cn.bravedawn.chapter10.packet.message.MessageRequestPacket;
import cn.bravedawn.chapter10.packet.message.MessageResponsePacket;
import cn.bravedawn.chapter10.utils.LoginUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.log4j.Log4j2;

import java.util.Date;
import java.util.Scanner;
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
                LoginUtil.markAsLogin(ctx.channel());
                log.info("{}: 客户端登录成功", new Date());
                Channel channel = ctx.channel();
                startConsoleThread(channel);
            } else {
                log.info("{}: 客户端登录失败, 失败原因: {}", new Date(), loginResponsePacket.getReason());
            }
        } else if (packet instanceof MessageResponsePacket) {
            MessageResponsePacket messageResponsePacket = (MessageResponsePacket) packet;
            log.info("{}: 收到服务端的消息: {}", new Date(), messageResponsePacket.getMessage());
        }
    }

    private static void startConsoleThread(Channel channel) {
        // 更佳实践：不要显示开启线程，而是使用线程池。
        new Thread(() -> {
            while (!Thread.interrupted()) {
                log.info("输入消息发送至服务器: ");
                Scanner sc = new Scanner(System.in);
                String line = sc.nextLine();

                MessageRequestPacket packet = new MessageRequestPacket();
                packet.setMessage(line);
                ByteBuf byteBuf = PacketCodec.INSTANCE.encode(channel.alloc(), packet);
                channel.writeAndFlush(byteBuf);
            }
        }).start();

    }

}
