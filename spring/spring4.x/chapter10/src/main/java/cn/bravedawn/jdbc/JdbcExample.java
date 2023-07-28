package cn.bravedawn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author : depers
 * @program : spring4.x
 * @description:
 * @date : Created in 2023/7/28 20:54
 */
public class JdbcExample {

    /**
     * 传统的使用JDBC访问数据库的过程
     */


    public static void main(String[] args) throws Exception {
        saveCustomer();
    }


    public static void saveCustomer() throws Exception {
        Connection connection = null;
        PreparedStatement stmt = null;


        try {
            // 1.准备资源
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?useSSL=false", "root", "fx1212");

            // 2.启动事务
            connection.setAutoCommit(false);

            // 3.具体的数据库访问操作和处理
            stmt = connection.prepareStatement("insert into `CUSTOMER` (ID, NAME, AGE) VALUES ( ?, ?, ? )");
            stmt.setLong(1, 1l);
            stmt.setString(2, "google");
            stmt.setInt(3, 18);
            stmt.execute();

            // 5.提交事务
            connection.commit();

        } catch (Exception e) {
            try {
                // 6.若发生异常进行回滚操作
                connection.rollback();
            } catch (SQLException s) {
                s.printStackTrace(System.out);
            }
            throw e;
        } finally {
            try {
                // 7.关闭资源，处理异常
                stmt.close();
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
