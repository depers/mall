package cn.bravedawn.listener;

import cn.bravedawn.context.ComponentContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author : depers
 * @program : new-platform
 * @date : Created in 2023/2/5 22:19
 */
public class ComponentContextInitializerListener implements ServletContextListener {

    private ServletContext servletContext;


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        this.servletContext = servletContextEvent.getServletContext();
        ComponentContext context = new ComponentContext();
        context.init(servletContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ComponentContext context = ComponentContext.getInstance();
        context.destroy();
    }
}
