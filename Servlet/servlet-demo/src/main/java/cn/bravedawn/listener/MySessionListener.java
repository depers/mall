package cn.bravedawn.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author : fengx9
 * @program : servlet-demo
 * @date : Created in 2022/05/27 4:52 PM
 */
@WebListener
public class MySessionListener implements HttpSessionListener {

    /**
     * 监听session的创建和销毁事件
     */

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session Created: ID=" + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session Destroyed: ID=" + se.getSession().getId());
    }
}
