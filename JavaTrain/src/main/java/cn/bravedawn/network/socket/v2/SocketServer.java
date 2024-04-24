package cn.bravedawn.network.socket.v2;

import lombok.extern.slf4j.Slf4j;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

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
            // 设置等待客户端与其建立连接的时间，如果超过这个时间没有客户端与其建立连接，则会报：Accept timed out。这个属性不建议设置，一直让其等待建立连接就好
            // serverSocket.setSoTimeout(5000);
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
                // 设置与客户端建立连接后，等待客户端发送数据的超时时间。若超过改时间，服务器就会报：Read timed out
                socket.setSoTimeout(60000);
                log.info("[{}]：接收到来自[{}]的请求", Thread.currentThread().getName(), socket.getRemoteSocketAddress());
                executorService.execute(new SocketServerHandler(socket));
            } catch (Throwable e) {
                log.error("接收请求异常", e);
            }
        }
    }


    public void printThreadPoolStatus() {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
        log.info("ThreadPoll status, 当前线程池中的线程数量={}, 线程池已执行和未执行的任务总数={}, 已完成的任务数量={}, 当前线程池中正在执行任务的线程数量={}",
                threadPoolExecutor.getPoolSize(), threadPoolExecutor.getTaskCount(), threadPoolExecutor.getCompletedTaskCount(),
                threadPoolExecutor.getActiveCount());
    }
}
