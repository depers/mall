package cn.bravedawn.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author : fengx9
 * @Project : mybatis-cache
 * @Date : Created in 2023-11-09 16:36
 */
public class Student implements Serializable {

    // 学号
    private Integer id;

    // 姓名
    private String name;

    // 年龄
    private Integer age;

    // 班级
    private String className;

    private Date birthTime;

    private Date birthTime2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(Date birthTime) {
        this.birthTime = birthTime;
    }

    public Date getBirthTime2() {
        return birthTime2;
    }

    public void setBirthTime2(Date birthTime2) {
        this.birthTime2 = birthTime2;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", className='" + className + '\'' +
                ", birthTime=" + birthTime +
                ", birthTime2=" + birthTime2 +
                '}';
    }
}
