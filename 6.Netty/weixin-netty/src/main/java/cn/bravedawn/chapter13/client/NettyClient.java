package cn.bravedawn.chapter13.client;

import cn.bravedawn.chapter12.packet.PacketCodec;
import cn.bravedawn.chapter12.packet.message.MessageRequestPacket;
import cn.bravedawn.chapter13.handler.Spliter;
import cn.bravedawn.chapter13.handler.clienthandler.LoginResponseHandler;
import cn.bravedawn.chapter13.handler.clienthandler.MessageResponseHandler;
import cn.bravedawn.chapter13.packet.PacketDecoder;
import cn.bravedawn.chapter13.packet.PacketEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;
import lombok.extern.log4j.Log4j2;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/2/5 16:24
 *
 * 带有重连逻辑的客户端
 */
@Log4j2
public class NettyClient {

    public static void main(String[] args) throws InterruptedException {
        // Bootstrap客户端启动的引导类，负责启动客户端和连接服务器
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap
                // 1.指定线程模型
                .group(group)
                // 2.指定io类型为NIO
                .channel(NioSocketChannel.class)
                // 3.IO处理逻辑，定义业务逻辑
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        channel.pipeline().addLast(new Spliter());
                        channel.pipeline().addLast(new PacketDecoder());
                        channel.pipeline().addLast(new LoginResponseHandler());
                        channel.pipeline().addLast(new MessageResponseHandler());
                        channel.pipeline().addLast(new PacketEncoder());
                    }
                });
        // 为NioSocketChannel绑定自定义属性
        bootstrap.attr(AttributeKey.newInstance("clientName"), "nettyClient");
        // 设置tcp属性
        bootstrap.option(ChannelOption.TCP_NODELAY, true);

        connect(bootstrap, "127.0.0.1", 1000, 1, 10);

    }

    /**
     * 带延时的重连
     */

    private static void connect(Bootstrap bootstrap, String host, int port, int retry, int maxRetry) {
        bootstrap.connect(host, port).addListener(future -> {
            log.info("尝试第" + retry + "连接");
            if (future.isSuccess()) {
                log.info("连接成功");
                Channel channel = ((ChannelFuture) future).channel();
                startConsoleThread(channel);
            } else if (retry == maxRetry) {
                System.err.println("重连次数耗尽，依旧无法连接, 关闭客户端Bootstrap");
            } else {
                int delay = 1 << (retry - 1);
                log.info(new Date() + " : 连接失败, 等待" + delay + "秒后, 尝试第" + retry + 1+ "连接");
                /**
                 * bootstrap.config()这个方法返回的是BootstrapConfig，它是对Bootstrap配置参数的抽象
                 * bootstrap.config().group()返回的就是我们在一开始配置的线程模型workerGroup，调用workerGroup的schedule方法即可实现定时任务逻辑。
                 */
                bootstrap.config().group().schedule(() -> connect(bootstrap, host, port, retry + 1, maxRetry), delay, TimeUnit.SECONDS);
            }
        });
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
