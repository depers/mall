package cn.bravedawn.chapter14;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/2/22 14:59
 */

@Slf4j
public class LifeCyCleTestHandler extends ChannelInboundHandlerAdapter {

    /**
     * 当检测到新连接之后
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        log.info("逻辑处理器被添加：handlerAdded()");
        super.handlerAdded(ctx);
    }

    /**
     * 当前channel的处理逻辑已和NIO线程建立了绑定关系
     */
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        log.info("channel 绑定到线程(NioEventLoop)：channelRegistered()");
        super.channelRegistered(ctx);
    }

    /**
     * channel被激活
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("channel 准备就绪：channelActive()");
        super.channelActive(ctx);
    }

    /**
     * 客户端向服务端发送数据，服务端每次都会回调此方法，表示有数据可读
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("channel 有数据可读：channelRead()");
        super.channelRead(ctx, msg);
    }

    /**
     * 服务端每读完一次完整的数据，都回调该方法，表示数据读取完毕。
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        log.info("channel 某次数据读完：channelReadComplete()");
        super.channelReadComplete(ctx);
    }

    /**
     * 连接已经被关闭了，这个连接在TCP层面已经不再是ESTABLISH状态
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("channel 被关闭：channelInactive()");
        super.channelInactive(ctx);
    }

    /**
     * 连接对应的NIO线程移除了对这个连接的处理。
     */
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        log.info("channel 取消线程(NioEventLoop) 的绑定：channelUnregistered()");
        super.channelUnregistered(ctx);
    }

    /**
     * 连接添加的所有业务逻辑处理器都被移除
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        log.info("逻辑处理器被删除：handlerRemoved()");
        super.handlerRemoved(ctx);
    }
}
