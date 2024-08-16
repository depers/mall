package cn.bravedawn.datetimetype;

import cn.bravedawn.entity.Student;
import cn.bravedawn.mapper.StudentDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author : depers
 * @program : mybatis-cache
 * @date : Created in 2024/8/15 11:12
 */
@Slf4j
@Component
public class DatetimeRunner implements ApplicationRunner {

    @Autowired
    private StudentDao studentDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Student student = new Student();
        student.setName("张三");
        student.setAge(18);
        LocalDateTime localDateTime = LocalDateTime.of(2024, 8, 15, 11, 24, 15, 999000000);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        Date date = Date.from(zonedDateTime.toInstant());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        log.info("出生时间是：{}", simpleDateFormat.format(date));
        student.setBirthTime(date);
        student.setBirthTime2(date);

        studentDao.addStudent(student);
    }
}
