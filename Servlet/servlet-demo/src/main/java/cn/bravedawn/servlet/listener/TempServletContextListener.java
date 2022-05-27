package cn.bravedawn.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author : depers
 * @program : servlet-demo
 * @date : Created in 2022/5/24 7:47
 */
//@WebListener
public class TempServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(sce.getServletContext().toString());
        System.out.println("Servlet container is initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Servlet container is shut down");
    }
}
