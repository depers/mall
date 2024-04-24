package cn.bravedawn.network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-19 11:19
 */
public class UDPReceive {


    /**
     * UDP接收方
     *
     * DatagramSocket 类用于表示发送和接收数据报包的套接字。数据报包套接字是包投递服务的发送或接收点。每个在数据报包套接字上发送或接收的包都是单独编址和路由的。
     * 从一台机器发送到另一台机器的多个包可能选择不同的路由，也可能按不同的顺序到达。
     *
     * DatagramPacket 类用来表示数据报包，数据报包用来实现无连接包投递服务。每条报文仅根据该包中包含的信息从一台机器路由到另一台机器。
     * 从一台机器发送到另一台机器的多个包可能选择不同的路由，也可能按不同的顺序到达。
     *
     * 先运行接收方，再运行发送方
     */

    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(1111);
        DatagramPacket datagramPacket = new DatagramPacket(new byte[1024], 1024);
        datagramSocket.receive(datagramPacket); // 接收数据

        byte[] arr = datagramPacket.getData(); // 获取数据
        int len = datagramPacket.getLength(); // 获取有效长度
        System.out.println(new String(arr, 0, len));
        datagramSocket.close(); // 关闭
    }
}
