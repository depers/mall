package cn.bravedawn.main;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author : depers
 * @program : mian-project
 * @description:
 * @date : Created in 2021/8/8 16:41
 */
public class TestListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println(servletContextEvent.
                getServletContext().getInitParameter("main") + "start!");

        System.out.println(servletContextEvent.
                getServletContext().getInitParameter("webFragment") + "start!");
        System.out.println("1111111111111111------------------------------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
