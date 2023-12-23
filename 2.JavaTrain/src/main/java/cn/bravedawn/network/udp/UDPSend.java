package cn.bravedawn.network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-19 11:20
 */
public class UDPSend {

    /**
     * UDP发送方
     */


    public static void main(String[] args) throws IOException { // 异常处理
        String str = "hello world";
        DatagramSocket datagramSocket = new DatagramSocket(); // 创建DatagramSocket
        DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(),
                str.getBytes().length, InetAddress.getByName("127.0.0.1"), 1111); // 创建DatagramPacket（要发送的数据，数据的长度，Ip地址，端口）
        datagramSocket.send(datagramPacket); // 发送
        datagramSocket.close(); // 关闭
    }
}
