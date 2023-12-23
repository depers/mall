package cn.bravedawn.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 17:28
 */
public class URLExample {


    /**
     * 获取网页数据
     */
    static void getFromURL1(String url) {
        URL u;
        try {
            u = new URL(url);
            URLConnection uc = u.openConnection();
            InputStream in = uc.getInputStream();
            byte[] b = new byte[1024];
            int len;
            while ((len = in.read(b)) != -1) {
                System.out.println(new String(b, 0, len));
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return;
    }


    //获取URL网页数据
    static void getFromURL2(String url) {
        URL u = null;
        BufferedReader in = null;
        try {
            u = new URL(url);
            in = new BufferedReader(new InputStreamReader(u.openStream(), "UTF-8"));
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return;
    }


    //获取URL服务器数据
    static void getURLDetails(String url){

        try {
            URL u=new URL(url);
            System.out.println(u);
            System.out.println("使用的协议： " + u.getProtocol()); //获取URL里面的超文本协议

            String host = u.getHost();
            if (host != null) {
                int atSign = host.indexOf('@');
                if (atSign != -1) host = host.substring(atSign+1);
                System.out.println("主机名称：" + host);
            } else {
                System.out.println("主机名称： null.");
            }

            System.out.println("端口号： " + u.getDefaultPort());
            System.out.println("默认端口：" + u.getDefaultPort());
            System.out.println("路径： " + u.getPath());
            System.out.println("定位位置： " + u.getRef());
            System.out.println("请求参数： " + u.getQuery());
            System.out.println("文件名及请求参数：" + u.getFile());
            System.out.println("验证信息：" + u.getAuthority());
        } catch (MalformedURLException ex) {
            System.err.println(url + " is not a URL I understand.");
        }
        return ;
    }

}

