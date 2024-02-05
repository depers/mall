package cn.bravedawn.chapter2;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/2/5 15:38
 */
public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + "hello world").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {

                    }
                }
            } catch (IOException e) {

            }
        }).start();
    }
}
