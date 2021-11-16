package cn.bravedawn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteDataDemo {

    public static void main(String[] args) {

        Connection connection = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?useSSL=false", "root", "fx1212");

            stmt = connection.createStatement();
            stmt.execute("delete from role where note = 'jdbc'");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
