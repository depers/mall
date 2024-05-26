package cn.bravedawn.network.socket.bio.v2;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;

/**
 * @Description : TODO
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-10-30 16:17
 */

@Slf4j
public class SocketServerHandler implements Runnable{

    private Socket socket;

    public SocketServerHandler(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        log.info("接收到请求----------------");
        BufferedWriter writer = null;
        BufferedReader reader = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String reqStr = null;
            while ((reqStr = reader.readLine()) != null){
                log.info("请求的报文是：{}", reqStr);
                // 这个地方写自己的路由逻辑
                String respStr = "200|success|hello";
                writer.write(respStr);
                writer.newLine();
                writer.flush();
                log.info("响应的报文是：{}", respStr);
                // 禁用该socket的输出流
                socket.shutdownOutput();
                break;
            }
        } catch (Throwable e) {
            log.error("服务端接收报文信息异常", e);
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }

                if (reader != null) {
                    reader.close();
                }
                // 关闭socket
                socket.close();
            } catch (Throwable e) {
                log.error("资源关闭异常", e);
            }

        }

    }
}
