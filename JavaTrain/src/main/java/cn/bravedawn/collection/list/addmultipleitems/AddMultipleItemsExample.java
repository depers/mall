package cn.bravedawn.collection.list.addmultipleitems;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/21 13:27
 */
public class AddMultipleItemsExample {

    /**
     * 添加多个元素到列表中
     * 可变对象：添加到新的list中的是对象的引用，所以修改其两个list中都有的元素属性，会同步体现到两个列表中
     * 不可变对象：由于Integer是不可变对象，所有两个list中都有的元素，修改其中一个元素，不会同步体现在两个列表中
     */

    public static void main(String[] args) {

        /**
         * 可变对象的添加
         */
        Plant p1 = new Plant("杜鹃", "red");
        Plant p2 = new Plant("玫瑰", "yellow");
        Plant p3 = new Plant("月季", "pink");
        Plant p4 = new Plant("兰花", "blue");

        List<Plant> plants = new ArrayList<>();
        plants.add(p1);
        plants.add(p2);
        plants.add(p3);

        List<Plant> plantList = new ArrayList<>(Arrays.asList(p4));
        plantList.addAll(plants);

        System.out.println("plants = " + plants);
        System.out.println("plantList = " + plantList);

        // 修改玫瑰的颜色
        plants.get(1).setColor("white");
        System.out.println("Modified plants = " + plants);
        System.out.println("Modified plantList = " + plantList);

        System.out.println("------------------------------------");

        /**
         * 不可变对象的添加
         */
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> anotherList = Arrays.asList(5, 12, 9, 3, 15, 88);
        list.addAll(anotherList);

        System.out.println("list = " + list);
        // 修改anotherList的一个元素
        anotherList.set(0, 99);
        System.out.println("modified anotherList = " + anotherList);
        System.out.println("modified list = " + list);
    }
}
