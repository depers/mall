package cn.bravedawn.basicoperate.dao;

import cn.bravedawn.basicoperate.domain.Forum;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author : depers
 * @program : spring4.x
 * @description:
 * @date : Created in 2023/8/3 21:19
 */

@Repository
public class ForumDao {

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_SQL = "INSERT INTO t_forum(forum_name,forum_desc) VALUES(?, ?)";
    private static final String SELECT_SQL = "SELECT forum_name,forum_desc FROM t_forum WHERE forum_id=?";
    private static final String SELECT_LIST_SQL = "SELECT forum_id,forum_name,forum_desc FROM t_forum WHERE forum_id between ? and ?";


    /**
     * 更新一条数据
     */
    public void addForm(final Forum forum) {

        // 方式一 通过sql和参数直接调用
        jdbcTemplate.update(INSERT_SQL, forum.getForumName(), forum.getForumDesc());


        // 【推荐使用】方式二 通过显示指定占位符所对应字段的数据类型
        // jdbcTemplate.update(INSERT_SQL, new int[] {Types.VARCHAR, Types.VARCHAR});


        // 方式三 通过PreparedStatementSetter回调接口执行参数绑定的操作
        // jdbcTemplate.update(INSERT_SQL, new PreparedStatementSetter() {
        //     public void setValues(PreparedStatement preparedStatement) throws SQLException {
        //         // 值得注意的是PreparedStatement参数绑定的下标是从1开始的，不是0
        //         preparedStatement.setString(1, forum.getForumName());
        //         preparedStatement.setString(2, forum.getForumDesc());
        //     }
        // });


        // 方式四 通过PreparedStatementCreator回调接口执行参数绑定的操作
        // jdbcTemplate.update(INSERT_SQL, new PreparedStatementCreator() {
        //     public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
        //         PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
        //         ps.setString(1, forum.getForumName());
        //         ps.setString(2, forum.getForumDesc());
        //         return ps;
        //     }
        // });


        // 方式五 插入一条记录的同时获取数据库生成的自增主键
        // 创建一个主键持有者
        // KeyHolder keyHolder = new GeneratedKeyHolder();
        // jdbcTemplate.update(new PreparedStatementCreator() {
        //     public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
        //         PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
        //         ps.setString(1, forum.getForumName());
        //         ps.setString(2, forum.getForumDesc());
        //         return ps;
        //     }
        // }, keyHolder);
        // // 获取主键
        // forum.setForumId(keyHolder.getKey().intValue());

    }


    /**
     * 批量更新数据
     * @param forums
     */
    public void addForums(final List<Forum> forums) {

        jdbcTemplate.batchUpdate(INSERT_SQL, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Forum forum = forums.get(i);
                preparedStatement.setString(1, forum.getForumName());
                preparedStatement.setString(2, forum.getForumDesc());
            }

            public int getBatchSize() {
                return forums.size();
            }
        });
    }


    /**
     * 根据ID获取Forum对象
     */
    public Forum getForum(final int forumId) {
        final Forum forum = new Forum();

        jdbcTemplate.query(SELECT_SQL, new Object[]{forumId}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                // 将结果集数据行中的数据抽取到forum对象中
                forum.setForumId(forumId);
                forum.setForumName(resultSet.getString("forum_name"));
                forum.setForumDesc(resultSet.getString("forum_desc"));
            }
        });
        return forum;
    }


    /**
     * 查询多条数据
     * @param fromId
     * @param toId
     * @return
     */
    public List<Forum> getForums(final int fromId, final int toId) {
        // 【推荐使用】方式一 使用RowCallbackHandler
        // final List<Forum> forums = new ArrayList<Forum>();
        // jdbcTemplate.query(SELECT_LIST_SQL, new Object[]{fromId, toId}, new RowCallbackHandler() {
        //     public void processRow(ResultSet resultSet) throws SQLException {
        //         Forum forum = new Forum();
        //         forum.setForumId(resultSet.getInt("forum_id"));
        //         forum.setForumName(resultSet.getString("forum_name"));
        //         forum.setForumDesc(resultSet.getString("forum_desc"));
        //         forums.add(forum);
        //     }
        // });
        // return forums;

        // 方式二 使用RowMapper
        return jdbcTemplate.query(SELECT_LIST_SQL, new Object[]{fromId, toId},
                new RowMapper<Forum>() {
                    public Forum mapRow(ResultSet rs, int i) throws SQLException {
                        Forum forum = new Forum();
                        forum.setForumId(rs.getInt("forum_id"));
                        forum.setForumName(rs.getString("forum_name"));
                        forum.setForumDesc(rs.getString("forum_desc"));
                        return forum;
                    }
                });
    }



}
