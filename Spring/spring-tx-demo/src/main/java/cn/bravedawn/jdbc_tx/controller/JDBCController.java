package cn.bravedawn.jdbc_tx.controller;

import cn.bravedawn.timeout.model.AccountInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * @author : depers
 * @program : spring-tx-demo
 * @date : Created in 2024/8/10 18:49
 */

@RestController
@Slf4j
public class JDBCController {

    @Autowired
    private DataSource dataSource;


    /**
     * 测试通过JDBC API控制事务
     * @return
     * @throws SQLException
     */
    @GetMapping("jdbc")
    public String jdbc() throws SQLException {

        Connection connection = DataSourceUtils.getConnection(dataSource);
        connection.setAutoCommit(false);
        String sql = "insert into account_info (account_no, biz_date) values (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        try {
            log.info("开始执行第一条数据");
            AccountInfo accountInfo = new AccountInfo();
            accountInfo.setAccountNo("110");
            accountInfo.setBizDate(new Date());
            statement.setString(1, accountInfo.getAccountNo());
            statement.setDate(2, new java.sql.Date(accountInfo.getBizDate().getTime()));
            statement.execute();

            log.info("第一条数据已落库");

            Thread.sleep(20000);
            int i = 1 / 0;
            log.info("开始执行第二条数据");
            statement.execute();
            connection.commit();
        } catch (Throwable e) {
            log.error("sql执行异常，事务回滚", e);
            try {
                connection.rollback();
            } catch (SQLException e2) {
                log.error("回滚事务出现异常", e2);
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }

        return "success";
    }
}
