package cn.bravedawn.chapter4;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/2/5 16:13
 */
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
                // 指定处理新连接数据的读写处理逻辑
                // NioSocketChannel是对NIO类型连接的抽象，类似BIO的Socket
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {

                    }
                })
                // 用于指定在服务端启动过程中的一些逻辑，通常情况下用不到这个方法
                .handler(new ChannelInitializer<NioServerSocketChannel>() {
                    @Override
                    protected void initChannel(NioServerSocketChannel nioServerSocketChannel) throws Exception {
                        System.out.println("服务端启动中");
                    }
                })
                // 给服务端Channel，也就是NioServerSocketChannel指定一些自定义属性
                .attr(AttributeKey.newInstance("serverName"), "nettyServer")
                // 给每一个连接都指定自定义属性
                .childAttr(AttributeKey.newInstance("clientKey"), "clientValue")
                // 给服务端Channel设置TCP参数
                .option(ChannelOption.SO_BACKLOG, 1024)
                // 给每个连接设置TCP参数
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true);

        serverBootstrap.bind(8000).addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("端口绑定成功");
                } else {
                    System.out.println("端口绑定失败");
                }
            }
        });
    }


    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("端口 ["+ port + "]绑定成功");
                } else {
                    System.out.println("端口 [" + port + "]绑定失败");
                    bind(serverBootstrap, port);
                }
            }
        });
    }
}
