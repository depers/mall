package cn.bravedawn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertDataDemo {

    public static void main(String[] args) {

        Connection connection = null;
        Statement insertStmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?useSSL=false", "root", "fx1212");

            insertStmt = connection.createStatement();
            insertStmt.execute("insert into role (id, role_name, note) values (4, 'lisa', 'jdbc')");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                insertStmt.close();
                connection.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
