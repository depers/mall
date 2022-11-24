package cn.bravedawn.controller;

import cn.bravedawn.entity.Class;
import cn.bravedawn.entity.Student;
import org.checkerframework.checker.units.qual.C;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecgframework.poi.excel.view.JeecgMapExcelView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : depers
 * @program : autopoi-demo
 * @date : Created in 2022/11/24 15:25
 */
@Controller
public class AutopoiController {

    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView(new JeecgMapExcelView());
        List<Class> pageList = getList();
        //导出文件名称
        mv.addObject(NormalExcelConstants.FILE_NAME, "班级表");
        //注解对象Class
        mv.addObject(NormalExcelConstants.CLASS, Class.class);
        //自定义表格参数
        mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("自定义导出Excel模板内容标题", "自定义Sheet名字"));
        //导出数据列表
        mv.addObject(NormalExcelConstants.DATA_LIST, pageList);
        return mv;
    }


    private List<Class> getList() {
        List<Class> classList = new ArrayList<>();

        List<Student> studentList = new ArrayList<Student>();
        Student student = new Student("冯晓", "男", 18);
        Student student2 = new Student("冯晓2", "男", 18);
        Student student3 = new Student("冯晓3", "男", 18);
        Student student4 = new Student("冯晓4", "男", 18);
        Student student5 = new Student("冯晓5", "男", 18);
        Student student6 = new Student("冯晓6", "男", 18);
        Student student7 = new Student("冯晓7", "男", 18);
        studentList.add(student);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        Class class1 = new Class("11班", studentList);
        classList.add(class1);

        List<Student> studentList2 = new ArrayList<Student>();
        studentList2.add(student5);
        Class class2 = new Class("12班", studentList2);
        classList.add(class2);

        List<Student> studentList3 = new ArrayList<Student>();
        studentList3.add(student6);
        studentList3.add(student7);
        Class class3 = new Class("6班", studentList3);
        classList.add(class3);

        return classList;
    }

}
