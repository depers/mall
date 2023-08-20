package cn.bravedawn.collection.list.copylist;

import java.util.ArrayList;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/19 13:08
 */
public class CopyListExample2 {

    /**
     * 拷贝列表中的元素到另一个列表：第二种方法使用addAll()方法
     */

    public static void main(String[] args) {
        Plant p1 = new Plant("杜鹃", "red");
        Plant p2 = new Plant("玫瑰", "yellow");
        Plant p3 = new Plant("月季", "pink");

        List<Plant> plants = new ArrayList<>();
        plants.add(p1);
        plants.add(p2);
        plants.add(p3);
        System.out.println("plants = " + plants);

        // 使用addAll()方法进行复制
        List<Plant> plantsCopy = new ArrayList<>();
        plantsCopy.addAll(plants);
        System.out.println("plantsCopy = " + plantsCopy);

        // 修改列表中一个元素的属性
        plantsCopy.get(1).setColor("white");
        System.out.println("Modified plants = " + plants);
        System.out.println("Modified plantsCopy = " + plantsCopy);

        // --------------------------------------------------------------

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("integer list = " + list);

        List<Integer> copy = new ArrayList<>();
        copy.addAll(list);
        System.out.println("integer copy list = " + copy);

        list.set(1, 0);
        System.out.println("Modified list = " + list);
        System.out.println("Modified copy list = " + copy);
    }
}
