package cn.bravedawn.user.web.listener;

import cn.bravedawn.user.context.ComponentContext;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author : depers
 * @program : mall
 * @description:
 * @date : Created in 2021/12/5 20:19
 */
public class DBConnectionInitializerListener implements ServletContextListener {

    private ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.servletContext = sce.getServletContext();
         Connection connection = getConnection();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }


    protected Connection getConnection() {
        Context context = null;
        Connection connection = null;
        try {
            context = new InitialContext();
            Context envContext = (Context) context.lookup("java:comp/env");
            DataSource dataSource = (DataSource) envContext.lookup("jdbc/UserPlatformDB");
            connection = dataSource.getConnection();

        } catch (NamingException | SQLException e) {
            servletContext.log(e.getMessage(), e);
        }

        if (connection != null) {
            servletContext.log("获取 JNDI 数据库连接成功");
        }

        return connection;
    }

}
