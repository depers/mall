package cn.bravedawn;


import cn.bravedawn.enums.CommentLevel;
import cn.bravedawn.service.StuService;
import cn.bravedawn.service.TestTransService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransTest {

    @Autowired
    private StuService stuService;

    @Autowired
    private TestTransService testTransService;

    @Test
    public void myTest() {
        // stuService.testPropagationTrans();
        testTransService.testPropagationTrans();
        // testTransService.testSelectPropagation();
    }

}
