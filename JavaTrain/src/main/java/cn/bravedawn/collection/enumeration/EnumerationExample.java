package cn.bravedawn.collection.enumeration;

import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/1/11 20:44
 */
public class EnumerationExample {

    /**
     * Enumeration的简单使用
     */

    public static void main(String[] args) {
        People p1 = new People("晓", "冯");
        People p2 = new People("那", "赵");
        Vector<People> peoples = new Vector<>(Arrays.asList(p1, p2));
        Enumeration<People> enumeration = peoples.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println("First Name = " + enumeration.nextElement().getFirstName());
        }
    }
}
