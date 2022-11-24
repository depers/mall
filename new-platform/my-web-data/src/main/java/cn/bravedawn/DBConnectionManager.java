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
        String databaseURL = "";
        Connection connection = DriverManager.getConnection(databaseURL);
        return connection;
    }
}
