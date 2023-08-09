package cn.bravedawn.basicoperate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : spring4.x
 * @description:
 * @date : Created in 2023/8/3 21:56
 */

@Repository
public class TopicDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 查询单值数据
     * @param userId
     * @return
     */
    public double getReplyRate(int userId) {
        String sql = "SELECT topic_replies,topic_views FROM t_topic WHERE user_id=?";

        double rate = jdbcTemplate.queryForObject(sql, new Object[]{userId},
                new RowMapper<Double>() {
                    public Double mapRow(ResultSet rs, int i) throws SQLException {
                        int replies = rs.getInt("topic_replies");
                        int views = rs.getInt("topic_views");
                        if(views > 0) {
                            return Double.valueOf(replies / views);
                        } else {
                            return Double.valueOf(0.0);
                        }
                    }
                });

        return rate;
    }


    /**
     * 调用存储过程
     * @param userId
     * @return
     */
    public int getUserTopicNum(final int userId) {
        String sql = "{call P_GET_TOPIC_NUM(?,?)}";

        // 方式一
        //Integer num = jdbcTemplate.execute(sql, new CallableStatementCallback<Integer>() {
        //    public Integer doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
        //        cs.setInt(1, userId);
        //        cs.registerOutParameter(2, Types.INTEGER);
        //        cs.execute();
        //        return cs.getInt(2);
        //    }
        //});
        //return num;

        // 方式二
        CallableStatementCreatorFactory fac = new CallableStatementCreatorFactory(sql);
        fac.addParameter(new SqlParameter("userId", Types.INTEGER));
        fac.addParameter(new SqlParameter("topicNum", Types.INTEGER));

        Map<String, Integer> paramsMap = new HashMap<String, Integer>();
        paramsMap.put("userId", userId);
        CallableStatementCreator csc = fac.newCallableStatementCreator(paramsMap);
        Integer num = jdbcTemplate.execute(csc, new CallableStatementCallback<Integer>() {
            public Integer doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.execute();
                return cs.getInt(2);
            }
        });

        return num;
    }

}
