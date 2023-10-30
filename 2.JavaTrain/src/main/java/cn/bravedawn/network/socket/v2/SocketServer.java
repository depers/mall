package cn.bravedawn.network.socket.v2;

import lombok.extern.slf4j.Slf4j;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description : TODO
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-10-30 15:24
 */
@Slf4j
public class SocketServer extends Thread{

    /**
     *  socket服务端
     */
    private ServerSocket serverSocket;

    /**
     * 线程池
     */
    private ExecutorService executorService;

    /**
     * 监听端口
     */
    private int port;


    public SocketServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
            log.info("Socket服务已启动，监听端口={}.", port);
        } catch (Throwable e) {
            log.error("初始化Socket服务器失败", e);
            // 程序正常退出
            System.exit(0);
        }

    }



    @Override
    public void run() {
        log.info("启动Socket接口访问服务");

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                socket.setSoTimeout(60000);
                log.info("[{}]：接收到来自[{}]的请求", Thread.currentThread().getName(), socket.getRemoteSocketAddress());
                executorService.execute(new SocketServerHandler(socket));
            } catch (Throwable e) {
                log.error("接收请求异常", e);
            }
        }
    }
}
