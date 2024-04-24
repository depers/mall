package cn.bravedawn.chapter2;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/2/5 15:30
 */
public class IOServer {

    public static void main(String[] args) throws Exception {
        final ServerSocket serverSocket = new ServerSocket(8000);
        // 接收新连接线程
        new Thread(() -> {
            while (true) {
                try {
                    // 阻塞方法获取新连接
                    final Socket socket = serverSocket.accept();
                    // 为每一个新连接都创建一个新线程，负责读取数据
                    new Thread(() -> {
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            // 按字节流方式读取数据
                            while ((len = inputStream.read(data)) != -1) {
                                System.out.println(new String(data, 0, len));
                            }
                        } catch (IOException e) {

                        }
                    }).start();
                } catch (IOException e) {

                }
            }
        }).start();
    }
}
