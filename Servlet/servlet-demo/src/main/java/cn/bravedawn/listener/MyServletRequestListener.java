package cn.bravedawn.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @author : fengx9
 * @program : servlet-demo
 * @date : Created in 2022/05/27 4:53 PM
 */
//@WebListener
public class MyServletRequestListener implements ServletRequestListener {

    /**
     * 当一个请求初始化和销毁时候监听请求的id地址
     */


    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletRequest request = sre.getServletRequest();
        System.out.println("ServletRequest initialized. Remote IP=" + request.getRemoteAddr());
    }


    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ServletRequest request = sre.getServletRequest();
        System.out.println("ServletRequest destroyed. Remote IP=" + request.getRemoteAddr());
    }
}
