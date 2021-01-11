package cn.bravedawn.es.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * @author : depers
 * @program : mall
 * @description: es索引
 * @date : Created in 2021/1/4 22:08
 */
@Document(indexName = "student", shards = 5)
public class Student {

    @Id
    // 设置该注解后，es的文档_id字段会和我们设置的id字段保持同步；不然文档中_id字段es会自动生成
    private Long id;

    @Field(store = true)
    private String name;

    @Field(store = true)
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
