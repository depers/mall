package cn.bravedawn.insert.controller;

import cn.bravedawn.dao.UserMapper;
import cn.bravedawn.service.UserService;
import cn.bravedawn.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : depers
 * @program : mybatis-batch-insert
 * @date : Created in 2024/8/9 20:22
 */

@RestController
@Slf4j
public class InsertController {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserService userService;

    /**
     * 不配置rewriteBatchedStatements参数：500ms
     * 配置rewriteBatchedStatements参数：520ms
     * @return
     */
    @GetMapping("oneByOneInsert")
    public String oneByOneInsert() {
        User user = new User();
        user.setName("冯晓");
        user.setAge(27);
        user.setGender(1);
        user.setPhone("17393164120");
        user.setFamilyAddress("陕西省西安市长安区融发心园");
        user.setEmail("dev_fengxiao@163.com");
        user.setMaritalStatus(0);
        user.setDateOfBirth("1996-11-30");
        user.setEducationBackground(1);
        user.setCreateUser("system");
        user.setUpdateUser("system");

        long startTime = System.currentTimeMillis();
        log.info("开始插入数据");
        for(int i = 0; i < 1000; i++) {
            // 这里是每次插入开一个事务
            userMapper.insertSelective(user);
        }

        log.info("插入数据耗时：{}ms", System.currentTimeMillis() - startTime);
        return "success";
    }


    /**
     * 不配置rewriteBatchedStatements参数：420ms
     * 配置rewriteBatchedStatements参数：400ms
     * @return
     */
    @GetMapping("oneByOneInsertV2")
    public String oneByOneInsertV2() {
        User user = new User();
        user.setName("冯晓");
        user.setAge(27);
        user.setGender(1);
        user.setPhone("17393164120");
        user.setFamilyAddress("陕西省西安市长安区融发心园");
        user.setEmail("dev_fengxiao@163.com");
        user.setMaritalStatus(0);
        user.setDateOfBirth("1996-11-30");
        user.setEducationBackground(1);
        user.setCreateUser("system");
        user.setUpdateUser("system");

        long startTime = System.currentTimeMillis();

        log.info("开始插入数据");
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                for(int i = 0; i < 1000; i++) {
                    // 这里是每次插入开一个事务
                    userMapper.insertSelective(user);
                }
            }
        });

        log.info("插入数据耗时：{}ms", System.currentTimeMillis() - startTime);
        return "success";
    }


    /**
     * 不配置rewriteBatchedStatements参数：95ms
     * 配置rewriteBatchedStatements参数：100ms
     * @return
     */
    @GetMapping("batchInsert")
    public String batchInsert() {
        User user = new User();
        user.setName("冯晓");
        user.setAge(27);
        user.setGender(1);
        user.setPhone("17393164120");
        user.setFamilyAddress("陕西省西安市长安区融发心园");
        user.setEmail("dev_fengxiao@163.com");
        user.setMaritalStatus(0);
        user.setDateOfBirth("1996-11-30");
        user.setEducationBackground(1);
        user.setCreateUser("system");
        user.setUpdateUser("system");

        List<User> userList = new ArrayList<>();

        for(int i = 0; i < 1000; i++) {
            userList.add(user);
        }

        long startTime = System.currentTimeMillis();
        log.info("开始插入数据");
        userMapper.batchInsert(userList);
        log.info("插入数据耗时：{}ms", System.currentTimeMillis() - startTime);
        return "success";
    }


    /**
     * 不配置rewriteBatchedStatements参数：100ms
     * 配置rewriteBatchedStatements参数：50ms
     * @return
     * @throws SQLException
     */
    @GetMapping("batchInsertV2")
    public String batchInsertV2() throws SQLException {
        User user = new User();
        user.setName("冯晓");
        user.setAge(27);
        user.setGender(1);
        user.setPhone("17393164120");
        user.setFamilyAddress("陕西省西安市长安区融发心园");
        user.setEmail("dev_fengxiao@163.com");
        user.setMaritalStatus(0);
        user.setDateOfBirth("1996-11-30");
        user.setEducationBackground(1);
        user.setCreateUser("system");
        user.setUpdateUser("system");

        List<User> userList = new ArrayList<>();

        long startTime = System.currentTimeMillis();
        log.info("开始插入数据");
        Connection connection = DataSourceUtils.getConnection(dataSource);
        connection.setAutoCommit(false);
        String sql = "insert into user (name, age, gender, phone, family_address, email, marital_status, date_of_birth, education_background, create_user, update_user) values (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        try {
            for(int i = 0; i < 1000; i++) {

                statement.setString(1, user.getName());
                statement.setInt(2, user.getAge());
                statement.setInt(3, user.getGender());
                statement.setString(4, user.getPhone());
                statement.setString(5, user.getFamilyAddress());
                statement.setString(6, user.getEmail());
                statement.setInt(7, user.getMaritalStatus());
                statement.setString(8, user.getDateOfBirth());
                statement.setInt(9, user.getEducationBackground());
                statement.setString(10, user.getCreateUser());
                statement.setString(11, user.getUpdateUser());
                statement.addBatch();
            }

            statement.executeBatch();
            connection.commit();
        } finally {
            statement.close();
            connection.close();
        }
        log.info("插入数据耗时：{}ms", System.currentTimeMillis() - startTime);
        return "success";
    }


    /**
     * 不配置rewriteBatchedStatements参数：95ms
     * 配置rewriteBatchedStatements参数：100ms
     * @return
     */
    @GetMapping("batchInsertV3")
    public String batchInsertV3() {
        User user = new User();
        user.setName("冯晓");
        user.setAge(27);
        user.setGender(1);
        user.setPhone("17393164120");
        user.setFamilyAddress("陕西省西安市长安区融发心园");
        user.setEmail("dev_fengxiao@163.com");
        user.setMaritalStatus(0);
        user.setDateOfBirth("1996-11-30");
        user.setEducationBackground(1);
        user.setCreateUser("system");
        user.setUpdateUser("system");

        List<User> userList = new ArrayList<>();

        for(int i = 0; i < 1000; i++) {
            userList.add(user);
        }

        long startTime = System.currentTimeMillis();
        log.info("开始插入数据");
        userService.saveBatch(userList);
        log.info("插入数据耗时：{}ms", System.currentTimeMillis() - startTime);
        return "success";
    }

}
