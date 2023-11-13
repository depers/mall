package cn.bravedawn.cache.mapper;

import cn.bravedawn.cache.entity.Student;
import org.apache.ibatis.annotations.Param;

/**
 * @Author : fengx9
 * @Project : mybatis-cache
 * @Date : Created in 2023-11-09 16:37
 */
public interface StudentDao {

        public Student getStudentById(int id);

        public int addStudent(Student student);

        public int updateStudentName(@Param("name") String name, @Param("id") int id);

        public Student getStudentByIdWithClassInfo(int id);
}
