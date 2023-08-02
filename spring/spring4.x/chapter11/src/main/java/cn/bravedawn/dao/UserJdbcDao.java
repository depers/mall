package cn.bravedawn.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int addUser() {
        String insetSql = "insert into `user` (name, age)values(?, ?)";

        jdbcTemplate.execute();
    }

}
