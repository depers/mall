package cn.bravedawn.other.reflectasm;

import com.esotericsoftware.reflectasm.MethodAccess;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/6/16 14:42
 */
public class MethodAccessExample {

    public static void main(String[] args) {
        MethodAccess methodAccess = MethodAccess.get(Student.class);
        Field[] fields = Student.class.getDeclaredFields();
        Field genderField = fields[0];
        genderField.setAccessible(true);
        System.out.println("Index: " + methodAccess.getIndex("get" + StringUtils.capitalize(genderField.getName())));
    }
}
