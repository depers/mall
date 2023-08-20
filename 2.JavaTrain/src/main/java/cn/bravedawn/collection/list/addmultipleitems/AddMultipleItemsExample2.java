package cn.bravedawn.collection.list.addmultipleitems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/21 14:22
 */
public class AddMultipleItemsExample2 {

    /**
     * 通过Collections.addAll()方法进行添加
     */

    public static void main(String[] args) {
        Plant p1 = new Plant("杜鹃", "red");
        Plant p2 = new Plant("玫瑰", "yellow");
        Plant p3 = new Plant("月季", "pink");
        Plant p4 = new Plant("兰花", "blue");

        List<Plant> list = new ArrayList<>(Arrays.asList(p4));

        // 入参是Collection和多个项
        Collections.addAll(list, p1, p2, p3);
        System.out.println(list);

        System.out.println("-------------------------------");
        List<Plant> list2 = new ArrayList<>();
        Plant[] otherList = new Plant[]{p1, p2, p3, p4};
        // 入参是Collection和数组
        Collections.addAll(list2, otherList);
        System.out.println(list2);


    }
}
