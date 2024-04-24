package cn.bravedawn.db;

import java.sql.Connection;

/**
 * @author : fengx9
 * @program : servlet-demo
 * @date : Created in 2022/05/27 4:59 PM
 */
public class DBConnectionManager {

    private String dbURL;
    private String user;
    private String password;
    private Connection con;


    public DBConnectionManager(String dbURL, String user, String password) {
        this.dbURL = dbURL;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() {
        return this.con;
    }

    public void closeConnection() {
        // close DB connection here
    }
}
