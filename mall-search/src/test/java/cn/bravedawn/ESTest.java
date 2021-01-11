package cn.bravedawn;

import cn.bravedawn.es.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchRestClientProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : depers
 * @program : mall
 * @description: 应用层
 * @date : Created in 2021/1/4 22:18
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class ESTest {

    @Autowired
    private ElasticsearchRestTemplate esTemplate;

    @Autowired
    ElasticsearchRestClientProperties properties;

    @Test
    public void createIndexStudent(){
        Student student = new Student();
        student.setId(1L);
        student.setName("王明");
        student.setAge(18);

        IndexQuery indexQuery = new IndexQueryBuilder().withObject(student).build();
        esTemplate.index(indexQuery, IndexCoordinates.of("stu"));

        log.info(properties.getUris().toString());
    }
}
