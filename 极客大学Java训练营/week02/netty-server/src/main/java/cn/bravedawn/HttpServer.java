package cn.bravedawn;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.util.SelfSignedCertificate;

/**
 * @author : depers
 * @program : netty-server
 * @description:
 * @date : Created in 2023/5/22 19:46
 */
public class HttpServer {

    private boolean ssl;
    private int port;

    public HttpServer(boolean ssl, int port) {
        this.port = port;
        this.ssl = ssl;
    }


    public void run() throws Exception{
        final SslContext sslCtx;
        if (ssl) {
            SelfSignedCertificate ssc = new SelfSignedCertificate();
            sslCtx = SslContext.newClientContext(ssc.certificate(), ssc.privateKey());
        } else {
            sslCtx = null;
        }

        EventLoopGroup bossGroup = new NioEventLoopGroup(3);
        EventLoopGroup workGroup = new NioEventLoopGroup(1000);
    }
}
