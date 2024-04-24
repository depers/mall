package cn.bravedawn.springhikaricp;

import lombok.extern.slf4j.Slf4j;
import org.h2.tools.Server;

import java.sql.SQLException;

/**
 * @Author : fengx9
 * @Project : hikaricp-demo
 * @Date : Created in 2023-12-04 10:55
 */

@Slf4j
public class H2Starter {

    /**
     * 在通过Server mode连接H2数据库的时候，如果没有单独去启动H2数据库，就会报：org.h2.jdbc.JdbcSQLNonTransientConnectionException: Connection is broken: "java.net.ConnectException: Connection refused: no further information: 127.0.0.1" [90067-224]
     * 这种情况下就需要我们显示的启动H2数据库
     */

    public static void startH2Server() {
        try {
            // 允许自动创建数据库
            Server server = Server.createTcpServer("-ifNotExists").start();
            if (server.isRunning(true)) {
                log.info("H2 server is started");
            } else {
                log.info("无法启动H2服务");
            }
        } catch (SQLException e) {
            throw new RuntimeException("启动H2服务失败");
        }
    }

}
