package cn.bravedawn.other.hutool.bean;

import cn.hutool.core.bean.BeanUtil;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/6/16 15:21
 */
public class BeanExample {

    /**
     * hutool的bean拷贝
     */

    public static void main(String[] args) {
        Student student = new Student();
        student.setGender("nan");
        student.setName("fx");

        StudentPeople studentPeople = new StudentPeople();

        BeanUtil.copyProperties(student, studentPeople);
        System.out.println(studentPeople);
    }
}
