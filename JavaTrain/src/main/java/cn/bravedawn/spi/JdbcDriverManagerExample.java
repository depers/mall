package cn.bravedawn.spi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDriverManagerExample {

    /**
     * 在这个例子中，我在maven中引入了mysql,h2和postgresql，在SPI加载驱动的时候这三个包中对java.sql.Driver的实现类都会被实例化
     */


    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/mybatis";
        Connection conn = DriverManager.getConnection(url, "root", "fx1212");
    }
}
