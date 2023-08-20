package cn.bravedawn.entity;

import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * @author : depers
 * @program : autopoi-demo
 * @date : Created in 2022/11/24 15:30
 */
public class Student {

    @Excel(name = "姓名")
    private String username;

    @Excel(name = "性别")
    private String gender;

    @Excel(name = "年龄")
    private int age;


    public Student(String username, String gender, int age) {
        this.username = username;
        this.gender = gender;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
