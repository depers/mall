package cn.bravedawn.user.sql;

import cn.bravedawn.user.context.ComponentContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author : depers
 * @program : mall
 * @description:
 * @date : Created in 2021/12/5 12:05
 */
public class DBConnectionManager {  // JNDI Component


    private final Logger logger = Logger.getLogger(DBConnectionManager.class.getName());

    public Connection getConnection() {
        ComponentContext context = ComponentContext.getInstance();

        // 依赖查找
        Connection connection = null;
        try {
            DataSource dataSource = context.getComponent("jdbc/UserPlatformDB");
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

        if (connection != null) {
            logger.log(Level.INFO, "获取 JNDI 数据库连接成功");
        }

        return connection;
    }
}
