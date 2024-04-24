package cn.bravedawn.service.impl;

import cn.bravedawn.mapper.StuMapper;
import cn.bravedawn.pojo.Stu;
import cn.bravedawn.service.StuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author 冯晓
 * @Date 2020/1/2 19:32
 */
@Service
@Slf4j
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    public void saveParent() {
        Stu stu = new Stu();
        stu.setName("parent");
        stu.setAge(19);
        stuMapper.insert(stu);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveChildren() {
        saveChild1();
//        try {
//            int a = 1 / 0;
//        } catch (Exception e) {
//            throw new ArithmeticException("算错了");
//        }
        saveChild2();
    }

    public void saveChildrenAsync() {
        saveChild3();
    }

    @Override
    public void saveSelectStuInfo() {
        Stu stu1 = new Stu();
        stu1.setId(1000);
        stu1.setName("select");
        stu1.setAge(18);
        stuMapper.insert(stu1);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void selectStuInfo() {
        Stu stu = new Stu();
        stu.setId(1000);
        Stu stu1 = stuMapper.selectOne(stu);
        if (stu1 == null){
            log.info("stu is null");
        } else{
            log.info("stu info = {}.", stu1.toString());
        }

    }

    @Override
    public void updateSelectStuInfo() {
        Stu stu = new Stu();
        stu.setId(1000);
        stu.setAge(11);
        stuMapper.updateByPrimaryKeySelective(stu);
    }

    public void saveChild1() {
        Stu stu1 = new Stu();
        stu1.setName("child-1");
        stu1.setAge(11);
        stuMapper.insert(stu1);
    }
    public void saveChild2() {
        Stu stu2 = new Stu();
        stu2.setName("child-2");
        stu2.setAge(22);
        stuMapper.insert(stu2);
    }

    public void saveChild3() {
        Stu stu1 = new Stu();
        stu1.setName("child-3");
        stu1.setAge(18);
        stuMapper.insert(stu1);
    }
}
