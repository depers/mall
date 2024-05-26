package cn.bravedawn.network.socket.nio.v2;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/5/25 18:34
 */
public class NioClient {

    private static NioClientTask nioClientTask;

    public static void main(String[] args) throws Exception {
        nioClientTask = new NioClientTask("127.0.0.1",8881);
        new Thread(nioClientTask,"nioClient").start();
        //控制台输入
        Scanner scanner = new Scanner(System.in);
        while(true){
            String message = scanner.next();
            if (!StringUtils.isEmpty(message)) {
                nioClientTask.sendMsg(message);
            }
        }
    }
}
