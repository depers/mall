package cn.bravedawn.chapter5;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Date;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/2/5 16:24
 */
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
                        channel.pipeline().addLast(new StringEncoder());
                    }
                });

        // connect是异步执行的
        bootstrap.connect("127.0.0.1", 8000).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("连接成功");
            } else {
                System.out.println("连接失败");
            }
        });

    }
}
