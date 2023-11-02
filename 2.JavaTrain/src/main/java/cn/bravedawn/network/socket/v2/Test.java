package cn.bravedawn.network.socket.v2;

import java.nio.charset.StandardCharsets;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-11-02 16:54
 */
public class Test {

    /**
     * 测试服务端和客户端
     */

    public static void main(String[] args) {
        // 启动服务器
        SocketServer socketServer = new SocketServer(6666);
        socketServer.start();

        // 启动客户端发送数据
        SocketClient socketClient = new SocketClient("localhost", 6666, StandardCharsets.UTF_8);
        socketClient.send("hello Beijing");
    }
}
