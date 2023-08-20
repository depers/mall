package cn.bravedawn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDataDemo {

    public static void main(String[] args) {

        Connection connection = null;
        Statement insertStmt = null;
        Statement selectStmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?useSSL=false", "root", "fx1212");

            insertStmt = connection.createStatement();
            insertStmt.execute("insert into role (id, role_name, note) values (4, 'lisa', 'jdbc')");
            insertStmt.execute("insert into role (id, role_name, note) values (5, 'jack', 'jdbc')");

            selectStmt = connection.createStatement();
            ResultSet rs = selectStmt.executeQuery("select id, role_name, note from role");

            while (rs.next()) {

                System.out.print(rs.getString(1));
                System.out.print(" ");
                System.out.print(rs.getString(2));
                System.out.print(" ");
                System.out.print(rs.getString(3));
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                selectStmt.close();
                insertStmt.close();
                connection.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
