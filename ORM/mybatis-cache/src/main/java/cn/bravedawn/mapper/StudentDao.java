package cn.bravedawn.mapper;

import cn.bravedawn.choose.QueryCondition;
import cn.bravedawn.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author : fengx9
 * @Project : mybatis-cache
 * @Date : Created in 2023-11-09 16:37
 */
public interface StudentDao {
    Student getStudentById(int id);

    int addStudent(Student student);

    int updateStudentName(@Param("name") String name, @Param("id") int id);

    Student getStudentByIdWithClassInfo(int id);

    List<Student> getAllStudent();

    List<Student> queryByQC(QueryCondition queryCondition);
}
