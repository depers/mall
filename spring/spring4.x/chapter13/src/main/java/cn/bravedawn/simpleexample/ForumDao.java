package cn.bravedawn.simpleexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author : depers
 * @program : spring4.x
 * @description:
 * @date : Created in 2023/8/3 21:02
 */


// @Repository
public class ForumDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void initDB() {
        String sql = "insert into `t_post_id` (`sequence_id`) values ( 1 )";
        jdbcTemplate.execute(sql);
    }


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-simpleexample.xml");
        ForumDao forumDao = (ForumDao) applicationContext.getBean("forumDao");
        forumDao.initDB();

    }
}
