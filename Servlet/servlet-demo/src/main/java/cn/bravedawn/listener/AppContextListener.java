package cn.bravedawn.listener;

import cn.bravedawn.db.DBConnectionManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author : fengx9
 * @program : servlet-demo
 * @date : Created in 2022/05/27 4:52 PM
 */

@WebListener
public class AppContextListener implements ServletContextListener {

    /**
     * 读取Servlet的初始化参数去创建DBConnectionManager对象，并将它作为参数放到Servlet上下文中
     */

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();

        String jdbcUrl = ctx.getInitParameter("DBURL");
        String username = ctx.getInitParameter("DBUSER");
        String password = ctx.getInitParameter("DBPWD");
        System.out.println("Init params are jdbcUrl=" + jdbcUrl + ", username=" + username);

        // create database connection from init parameters and set it to context
        DBConnectionManager dbManager = new DBConnectionManager(jdbcUrl, username, password);
        ctx.setAttribute("DBManager", dbManager);
        System.out.println("Database connection initialized for Application.");

    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();

        DBConnectionManager dbManager = (DBConnectionManager) ctx.getAttribute("DBManager");
        dbManager.closeConnection();
        System.out.println("Database connection closed for Application.");
    }
}
