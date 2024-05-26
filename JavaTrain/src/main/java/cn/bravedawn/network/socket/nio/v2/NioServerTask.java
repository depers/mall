package cn.bravedawn.network.socket.nio.v2;


import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/5/25 18:12
 */

@Slf4j
public class NioServerTask implements Runnable {
    private volatile boolean started;
    private ServerSocketChannel serverSocketChannel;
    private Selector selector;

    /**
     * 构造方法
     *
     * @param port 指定要监听的端口号
     */
    public NioServerTask(int port) {
        try {
            //创建一个选择器
            selector = Selector.open();
            //创建ServerSocketChannel的实例
            serverSocketChannel = ServerSocketChannel.open();
            //通道实例设置为非阻塞模式
            serverSocketChannel.configureBlocking(false);
            //绑定端口
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            //注册事件到selector之上，监听客户端连接
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            started = true;
            log.info("服务器已启动，端口号：" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (started) {
            try {
                //selector每隔1s被唤醒一次
                selector.select(1000);
                //获取全部已经注册的本地事件
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    //将处理过的本地注册事件给删除
                    iterator.remove();
                    handleInput(key);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //处理具体的事件
    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()) {
            //处理新接入的客户端的请求
            if (key.isAcceptable()) {
                //获取channels全部事件中对此感兴趣的事件
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                //获取到感兴趣的事件之后，创建一个socket实例，用于发送和读取数据
                SocketChannel sc = ssc.accept();
                //设置为非阻塞
                sc.configureBlocking(false);
                //注册一个感兴趣的读事件
                sc.register(selector, SelectionKey.OP_READ);
            }
            //处理对端的发送的数据
            if (key.isReadable()) {
                SocketChannel sc = (SocketChannel) key.channel();
                //创建ByteBuffer，开辟一个缓冲区
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(buffer);
                if (readBytes > 0) {
                    //缓冲区中存在指针，记录有效位置
                    buffer.flip();
                    //根本有效位置的指针处创建字节数组
                    byte[] bytes = new byte[buffer.remaining()];
                    //将缓冲区可读字节数组复制到新建的数组中
                    buffer.get(bytes);
                    String message = new String(bytes, "UTF-8");
                    log.info("服务器收到消息：" + message);
                    String result = LocalDateTime.now() + "hello: " + message;
                    doWrite(sc, result);
                    buffer.clear();
                } else if (readBytes < 0) {
                    //将channels集合的数据取消
                    key.cancel();
                    sc.close();
                }
            }
        }
    }

    /*发送应答消息*/
    private void doWrite(SocketChannel sc, String response) throws IOException {
        byte[] bytes = response.getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.put(bytes);
        buffer.flip();
        sc.write(buffer);
    }
}