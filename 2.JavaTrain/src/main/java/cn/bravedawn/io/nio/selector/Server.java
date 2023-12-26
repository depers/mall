package cn.bravedawn.io.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-25 15:53
 */
public class Server {

    /**
     * 服务端
     */


    public static void main(String[] args) throws IOException {
        // 创建一个选择器
        Selector selector = Selector.open();
        System.out.println("Selector is open for making connection: " + selector.isOpen());
        // 获取服务器套接字通道
        ServerSocketChannel SS = ServerSocketChannel.open();
        InetSocketAddress hostAddress = new InetSocketAddress("localhost", 8080);
        SS.bind(hostAddress);
        SS.configureBlocking(false);
        int ops = SS.validOps();
        // 使用选择器进行注册
        SelectionKey selectKy = SS.register(selector, ops, null);
        for (; ; ) {
            System.out.println("Waiting for the select operation...");
            // 获取有多少通道已经准备好进行通信
            int noOfKeys = selector.select();
            System.out.println("The Number of selected keys are: " + noOfKeys);

            // 获取需要进行IO处理的channel
            Set selectedKeys = selector.selectedKeys();
            Iterator itr = selectedKeys.iterator();
            while (itr.hasNext()) {
                SelectionKey ky = (SelectionKey) itr.next();
                if (ky.isAcceptable()) {
                    // 接受新的客户端连接
                    SocketChannel client = SS.accept();
                    client.configureBlocking(false);
                    // 将新的连接添加到选择器上，并监听OP_READ事件
                    client.register(selector, SelectionKey.OP_READ);
                    System.out.println("The new connection is accepted from the client: " + client);
                } else if (ky.isReadable()) {
                    // 从客户端读取数据
                    SocketChannel client = (SocketChannel) ky.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(256);
                    int bytesRead = client.read(buffer);
                    if (bytesRead > 0) {
                        buffer.flip();
                        String output = new String(buffer.array()).trim();
                        System.out.println("Message read from client: " + output);
                        if (output.equals("Bye Bye")) {
                            client.close();
                            System.out.println("The Client messages are complete; close the session.");
                        }
                    } else if (bytesRead < 0) {
                        // 客户端断开连接
                        client.close();
                    }

                }
                itr.remove();
            } // end of while loop
        } // end of for loop
    }
}
