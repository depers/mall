package cn.bravedawn;

import cn.bravedawn.es.pojo.Student;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchRestClientProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

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
    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    ElasticsearchRestClientProperties properties;


    /**
     * 不建议使用 ElasticsearchTemplate 对索引进行管理（创建索引，更新索引，删除索引）
     * 原因：1.索引就像是数据库或者数据库中的表，我们平时是不会通过Java代码频繁的去创建修改珊瑚数据库或者是表的；
     *      我们只会针对数据做CRUD的操作，在es中也是同理，我们尽量使用ElasticsearchTemplate 对文档数据做CRUD的操作
     *      2. 声明文档对象时(FieldTYpe)类型不灵活
     *      3. 主分片与副本分片树无法设置
     */
    @Test
    public void createIndexStudent(){
        Student student = new Student();
        student.setId(1L);
        student.setName("王明");
        student.setAge(18);
        // 更新文档和数据
        student.setMoney(18.8f);
        student.setSign("i am spider man");
        student.setDescription("I wish i am spider man");

        IndexQuery indexQuery = new IndexQueryBuilder().withObject(student).build();
        elasticsearchOperations.index(indexQuery, IndexCoordinates.of("student"));
    }

    @Test
    public void deleteIndexStudent(){
        IndexOperations indexOperations = elasticsearchOperations.indexOps(Student.class);
        indexOperations.delete();
    }


    @Test
    public void updateStudentDoc(){
        Map<String, Object> docMap = new HashMap<>();
        docMap.put("name", "冯晓");
        docMap.put("age", 19);
        docMap.put("sign", "冯晓加油");

        Document document = Document.from(docMap);
        UpdateQuery updateQuery = UpdateQuery.builder("1").withDocument(document).build();
        elasticsearchOperations.update(updateQuery, IndexCoordinates.of("student"));
    }


    @Test
    public void bulkInsertStudentDoc(){
        List<IndexQuery> queryList = new ArrayList<>();

        Student student = new Student();
        student.setId(2L);
        student.setName("王明");
        student.setAge(18);
        student.setMoney(18.8f);
        student.setSign("i am spider man");
        student.setDescription("I wish i am spider man");
        queryList.add(new IndexQueryBuilder().withObject(student).build());

        Student stu2 = new Student();
        BeanUtils.copyProperties(student, stu2);
        stu2.setId(3L);
        stu2.setName("李静");
        queryList.add(new IndexQueryBuilder().withObject(stu2).build());

        Student stu3 = new Student();
        BeanUtils.copyProperties(student, stu3);
        stu3.setId(4L);
        stu3.setName("赵四");
        queryList.add(new IndexQueryBuilder().withObject(stu3).build());

        List<String> ids = elasticsearchOperations.bulkIndex(queryList, IndexCoordinates.of("student"));

        log.info("ids={}.", ids.toString());
    }


    @Test
    public void searchStudentDoc(){


//        Query query = new NativeSearchQueryBuilder()
//                            .withQuery(QueryBuilders.matchQuery())
//        elasticsearchOperations.search()
    }
}
