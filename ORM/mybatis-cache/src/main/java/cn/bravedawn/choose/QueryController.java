package cn.bravedawn.choose;

import cn.bravedawn.entity.Student;
import cn.bravedawn.mapper.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : depers
 * @program : mybatis-cache
 * @date : Created in 2024/8/13 10:17
 */

@RestController
public class QueryController {

    @Autowired
    private StudentDao studentDao;


    @GetMapping("query")
    public String query() {
        QueryCondition queryCondition = new QueryCondition();
        queryCondition.setAge(18);
        queryCondition.setName("小米");
        List<Student> students = studentDao.queryByQC(queryCondition);
        System.out.println(students);
        return "success";
    }
}
