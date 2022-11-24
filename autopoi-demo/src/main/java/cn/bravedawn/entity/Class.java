package cn.bravedawn.entity;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;

import java.util.List;

/**
 * @author : depers
 * @program : autopoi-demo
 * @date : Created in 2022/11/24 15:59
 */
public class Class {

    @Excel(name = "班级名称", orderNum = "1", needMerge = true)
    private String name;

    @ExcelCollection(name = "选课学生", orderNum = "2")
    private List<Student> students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Class(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }
}
