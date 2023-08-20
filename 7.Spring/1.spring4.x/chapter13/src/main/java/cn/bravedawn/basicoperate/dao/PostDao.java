package cn.bravedawn.basicoperate.dao;

import cn.bravedawn.basicoperate.domain.Post;
import com.mysql.jdbc.MySQLConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.support.AbstractLobStreamingResultSetExtractor;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class PostDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private LobHandler lobHandler;

    @Autowired
    private DataFieldMaxValueIncrementer incre;

    /**
     * 获取数据库原生的本地数据库连接
     */
    public void getNativeConnection() {
        try {
            Connection connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            // 通过jdbcTemplate配置时注入的本地JDBC对象抽取器
            connection = jdbcTemplate.getNativeJdbcExtractor().getNativeConnection(connection);
            MySQLConnection mySQLConnection = (MySQLConnection) connection;
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }


    /**
     * 插入LOB类型的数据
     * @param post
     */
    public void addPost(final Post post) {
        String sql = " INSERT INTO t_post(post_id,user_id,post_text,post_attach)"
                + " VALUES(?,?,?,?)";
        jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(lobHandler) {
            @Override
            protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException, DataAccessException {
                // 固定主键
                // ps.setInt(1, 1);

                // 通过自增键生成主键值
                ps.setInt(1, incre.nextIntValue());
                ps.setInt(2, post.getUserId());
                lobCreator.setClobAsString(ps, 3, post.getPostText());
                lobCreator.setBlobAsBytes(ps, 4, post.getPostAttach());
            }
        });
    }


    /**
     * 以块的方式读取LOB数据，如果lob数据的体积过大，用块的方式读取需要消耗大量的内存，会直接影响程序的运行，所以可以使用流的方式读取lob数据，减少内存的访问。
     * @param userId
     * @return
     */
    public List getAttaches(final int userId) {
        String sql = " SELECT post_id,post_attach FROM t_post where user_id =? and post_attach is not null ";
        return jdbcTemplate.query(sql, new Object[]{userId},
                new RowMapper<Post>() {
                    @Override
                    public Post mapRow(ResultSet rs, int i) throws SQLException {
                        int postId = rs.getInt(1);
                        // 以二进制的方式获取Blob数据
                        byte[] attach = lobHandler.getBlobAsBytes(rs, 2);
                        Post post = new Post();
                        post.setPostId(postId);
                        post.setPostAttach(attach);
                        return post;
                    }
                });
    }


    /**
     * 使用流的方式读取lob数据，减少内存的访问
     * @param postId
     * @param os
     */
    public void getAttach(final int postId, final OutputStream os) {
        String sql = "SELECT post_attach FROM t_post WHERE post_id=?";
        jdbcTemplate.query(sql, new Object[]{postId}, new AbstractLobStreamingResultSetExtractor<Object>() {
            @Override
            protected void streamData(ResultSet rs) throws SQLException, IOException, DataAccessException {
                InputStream is = lobHandler.getBlobAsBinaryStream(rs, 1);
                if (is != null) {
                    FileCopyUtils.copy(is, os);
                }
            }
            @Override
            protected void handleNoRowFound() throws DataAccessException {
                System.out.println("Not Found result");
            }
        });
    }
}
