package cn.bravedawn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 获取数据库连接
 *
 * @author : depers
 * @program : new-platform
 * @description:
 * @date : Created in 2022/11/24 22:21
 */
public class DBConnectionManager {

    /**
     * 采用Java SPI机制去获取数据库连接
     * @return
     * @throws Exception
     */

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        String databaseURL = "jdbc:h2:/Users/depers/h2/data.h2;AUTO_SERVER=TRUE;MODE=MYSQL;DATABASE_TO_LOWER=TRUE;";
        Connection connection = DriverManager.getConnection(databaseURL, "root", "fx1212");
        return connection;
    }
}
