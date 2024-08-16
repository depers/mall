package cn.bravedawn.select.controller;

import cn.bravedawn.entity.Student;
import cn.bravedawn.mapper.StudentDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : depers
 * @program : mybatis-cache
 * @date : Created in 2024/8/12 10:37
 */
@RestController
@Slf4j
public class SelectController {

    @Autowired
    private StudentDao studentDao;


    /**
     * 如果数据库中没有一条数据，Mybatis查出来的List会是什么？
     * @return
     */
    @GetMapping("selectList")
    public String selectList(){

        List<Student> students = studentDao.getAllStudent();
        log.info("list是否为null, result={}", students == null);
        log.info("list是否为空, result={}", students.isEmpty());
        log.info(students.toString());
        students.forEach(item -> log.info(item.toString()));
        List<Student> collect = students.stream().map(Function.identity()).collect(Collectors.toList());
        log.info("collect result={}", collect);
        return "success";
    }
}
