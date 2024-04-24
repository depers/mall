package cn.bravedawn;

import cn.bravedawn.basicoperate.dao.TopicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

/**
 * @author : depers
 * @program : spring4.x
 * @description:
 * @date : Created in 2023/8/10 21:21
 */


@ContextConfiguration(locations = {"classpath:applicationContext-simpleexample.xml"})
@Rollback
@Transactional
public class TestTopicDao extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private TopicDao topicDao;


    @Test
    public void testGetTopicRowSet() {
        SqlRowSet srs = topicDao.getTopicRowSet(1);
        while (srs.next()) {
            System.out.println(srs.getString("topic_id"));
        }
    }
}
