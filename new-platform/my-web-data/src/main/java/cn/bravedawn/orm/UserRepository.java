package cn.bravedawn.orm;

import cn.bravedawn.entity.Member;
import cn.bravedawn.orm.annotations.*;

import java.util.List;

/**
 * @author : fengx9
 * @program : new-platform-main
 * @date : Created in 2023/03/01 11:19 AM
 */
@Repository
public interface UserRepository {

    @Select("select * from member where id = #{id}")
    Member selectById(Long id);

    @Insert("insert into member (id, username, password, email) values (#{id}, #{username}, #{password}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertOne(Member member);

    @Update("update member set username = #{username}, password = #{password}, email = {email} where id = #{id}")
    int updateByPrimaryKey(Member member);

    @Delete("delete member where id = #{id}")
    int deleteByPrimaryKey(Long id);

    @Select("select * from member where username = #{username}")
    List<Member> selectList(String username);
}
