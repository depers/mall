package cn.bravedawn.network.socket.v1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description : Socket服务端
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-10-08 11:09
 */
public class Server {


    public static void main(String[] args) throws IOException {
        // 监听6666端口
        ServerSocket server = new ServerSocket(6666);
        System.out.println("Server is running.");
        while (true) {
            // 接收新的连接
            Socket socket = server.accept();
            System.out.println("connected from " + socket.getRemoteSocketAddress());
            Thread t = new Handler(socket);
            t.start();
        }
    }
}
