package cn.bravedawn.network.socket.v2;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-11-02 16:04
**/

@Slf4j
public class SocketClient {

    /**
     * Socket客户端
     */

    private final String host;
    private final int port;
    private final Charset charset;
    private Socket socketClient;

    public SocketClient(String host, int port, Charset charset) {
        log.info("Socket客户端地址：host={}, port={}, charset={}.", host, port, charset);
        this.host = host;
        this.port = port;
        this.charset = charset;
    }


    public String send(String reqStr) {
        log.info("客户端Socket启动");

        BufferedWriter writer = null;
        BufferedReader reader = null;
        StringBuilder respStr = new StringBuilder();

        try {
            socketClient = new Socket(InetAddress.getByName(host), port);
            // 设置发送数据给服务端之后，等待服务端响应报文的时间，如果超过这个时间就会报：Read time out
            socketClient.setSoTimeout(5000);

            // 发送请求报文
            writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream(), StandardCharsets.UTF_8));
            log.info("客户端发送报文内容：{}", reqStr);
            writer.write(reqStr);
            writer.newLine();
            writer.flush();

            // 接收响应报文
            reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream(), StandardCharsets.UTF_8));
            int ch = 0;
            while ((ch = reader.read()) != -1) {
                respStr.append((char) ch);
            }
            log.info("客户端接收到响应报文");

        } catch (Throwable e) {
            log.error("发送请求失败", e);
        } finally {
            try {
                socketClient.close();
                if (writer != null) {
                    writer.close();
                }

                if (reqStr != null) {
                    reader.close();
                }
            } catch (Throwable e) {
                log.error("IO资源关闭异常", e);
            }
        }

        return respStr.toString();
    }


}
