package cn.bravedawn.chapter19.server;

import cn.bravedawn.chapter19.handler.Spliter;
import cn.bravedawn.chapter19.handler.serverhandler.*;
import cn.bravedawn.chapter19.packet.PacketCodecHandler;
import cn.bravedawn.chapter19.packet.PacketDecoder;
import cn.bravedawn.chapter19.packet.PacketEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import lombok.extern.log4j.Log4j2;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/2/5 16:13
 *
 * 递增绑定端口
 */
@Log4j2
public class NettyServer {

    public static void main(String[] args) {
        // 负责引导服务端的启动工作
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        // boss对应IOServer.java中的负责接收新连接的线程，主要负责创建新连接
        NioEventLoopGroup boss = new NioEventLoopGroup();
        // worker对应IOServer.java中的负责读取数据的线程，主要用于读取数据及业务逻辑处理
        NioEventLoopGroup work = new NioEventLoopGroup();

        serverBootstrap
                // 设置引导类的线程模型
                .group(boss, work)
                // 指定IO模型为NIO
                // NioServerSocketChannel类似ServerSocket的抽象
                .channel(NioServerSocketChannel.class)
                // 定义后续每个连接的数据读写
                // NioSocketChannel是对NIO类型连接的抽象，类似BIO的Socket
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    // 每次有新连接到来的时候，都会调用ChannelInitializer的initChannel()方法，然后这9个与指令相关的Handler都会被创建一次
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        // 对于Pipeline中的第一个Handler—Spliter，我们是无法改动它的，因为它的内部实现与每个Channel都有关，
                        // 每个Spliter都需要维持每个Channel当前读到的数据，也就是说它是有状态的。
                        ch.pipeline().addLast(new Spliter());
                        ch.pipeline().addLast(PacketCodecHandler.INSTANCE);
                        ch.pipeline().addLast(LoginRequestHandler.INSTANCE);
                        ch.pipeline().addLast(AuthHandler.INSTANCE);
                        ch.pipeline().addLast(IMHandler.INSTANCE);
                    }
                });

        serverBootstrap.childOption(ChannelOption.TCP_NODELAY, true);
        bind(serverBootstrap, 1000);
    }


    /**
     * 如果端口绑定失败，则递增绑定端口
     */
    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                if (future.isSuccess()) {
                    log.info("端口 ["+ port + "]绑定成功");
                } else {
                    log.info("端口 [" + (port + 1) + "]绑定失败");
                    bind(serverBootstrap, port + 1);
                }
            }
        });
    }
}
