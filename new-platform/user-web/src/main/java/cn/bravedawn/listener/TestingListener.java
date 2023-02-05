package cn.bravedawn.listener;

import cn.bravedawn.context.ComponentContext;
import cn.bravedawn.sql.DBConnectionManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author : depers
 * @program : new-platform
 * @date : Created in 2023/2/5 22:10
 */
public class TestingListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ComponentContext context = ComponentContext.getInstance();
        DBConnectionManager dbConnectionManager = context.getComponent("bean/DBConnectionManager");
        dbConnectionManager.getConnection();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
