package cn.bravedawn.obj.bean.copyproperties.spring;

import cn.bravedawn.obj.bean.copyproperties.Address;
import cn.bravedawn.obj.bean.copyproperties.People;
import cn.bravedawn.obj.bean.copyproperties.Student;
import org.springframework.beans.BeanUtils;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-05 15:44
 */
public class SpringBeanCopyPropertiesExample {


    public static void main(String[] args) {
        Address address = new Address();
        address.setAddressName("甘肃省张掖市临泽县");

        People people = new People();
        people.setName("小明");
        people.setGender("男");
        people.setAge(11);
        people.setAddress(address);


        Student student = new Student();

        BeanUtils.copyProperties(people, student);

        System.out.println("People: " + people);
        System.out.println("Student: " + student);
    }
}
