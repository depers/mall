package cn.bravedawn.io.serializable;

import java.io.ObjectStreamClass;
import java.io.ObjectStreamField;
import java.util.Calendar;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-15 17:26
 */
public class ObjectStreamFieldExample {


    /**
     * 获取Serializable类的字段说明
     *
     * getField()：获取ObjectStreamField对象
     * getTypeCode()：获取字段类型的字符编码
     */

    public static void main(String[] args) {

        // create a new object stream class for Calendar
        ObjectStreamClass osc2 = ObjectStreamClass.lookup(Calendar.class);

        // get the Class instance for osc2
        ObjectStreamField field = osc2.getField("isTimeSet");
        System.out.println(field);
        System.out.println(field.getTypeCode());
    }
}
