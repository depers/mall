package cn.bravedawn.sql;

import cn.bravedawn.context.ComponentContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author : depers
 * @program : new-platform
 * @date : Created in 2023/2/5 22:03
 */
public class DBConnectionManager {

    private final Logger logger = Logger.getLogger(DBConnectionManager.class.getName());


    public Connection getConnection() {
        ComponentContext context = ComponentContext.getInstance();
        // 依赖查找
        DataSource dataSource = context.getComponent("jdbc/UserPlatformDB");
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        if (connection != null) {
            logger.log(Level.INFO, "获取 JNDI 数据库连接成功！");
        }
        return connection;
    }


}
