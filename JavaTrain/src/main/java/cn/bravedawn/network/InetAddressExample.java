package cn.bravedawn.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 17:25
 */
public class InetAddressExample {

    public static void main(String[] args) throws UnknownHostException {
        String host = "127.0.0.1";
        InetAddress inetAddress = InetAddress.getByName(host);
        InetAddress inetAddress2 = InetAddress.getByAddress(host.getBytes());
    }
}
