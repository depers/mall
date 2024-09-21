package cn.bravedawn.util;

import jakarta.servlet.http.HttpServletRequest;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author : depers
 * @program : quartz-dynamic-job
 * @date : Created in 2024/9/21 13:49
 */
public class IPUtil {

    public static String getServerIp() {
        try {
            // 根据网卡获取本机配置的ip
            InetAddress inet = null;
            try {
                inet = InetAddress.getLocalHost();
            } catch (UnknownHostException e) {

            }

            String ip = null;
            if (inet != null) {
                ip = inet.getHostAddress();
            }

            // 对于通过多个代理的情况，第一个ip为客户端真是的ip，多个ip按照“,”分割
            if (ip != null && ip.length() > 15) {
                if (ip.indexOf(",") > 0) {
                    ip = ip.substring(0, ip.indexOf(","));
                }
            }
            return ip;
        } catch (Exception e) {
            return "0.0.0.0";
        }
    }

    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip.equals("127.0.0.1") || ip.equals("0:0:0:0:0:0:0:1")) {
                // 根据网卡获取本机配置的ip
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {

                }

                if (inet != null) {
                    ip = inet.getHostAddress();
                }
            }
        }

        // 对于通过多个代理的情况，第一个ip为客户端真是的ip，多个ip按照“,”分割
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }


    public static void main(String[] args) {
        System.out.println(getServerIp());
    }
}
