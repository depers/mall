package cn.bravedawn.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * @author : fengx9
 * @program : servlet-demo
 * @date : Created in 2022/05/27 4:52 PM
 */
//@WebListener
public class AppContextAttributeListener implements ServletContextAttributeListener {

    /**
     * 监听Servlet上下文中参数的新增，修改，删除事件
     */

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("ServletContext attribute added: {" + event.getName() + ", " + event.getValue() + "}.");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("ServletContext attribute replaced: {" + event.getName() + ", " + event.getValue() + "}.");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("ServletContext attribute removed: {" + event.getName() + ", " + event.getValue() + "}.");
    }
}
