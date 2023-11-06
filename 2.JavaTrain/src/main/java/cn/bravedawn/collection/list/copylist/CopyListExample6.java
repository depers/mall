package cn.bravedawn.collection.list.copylist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/28 21:25
 */
public class CopyListExample6 {

    /**
     * 使用List.copy()方法去复制一个可变对象的list
     */


    public static void main(String[] args) {

        Plant p1 = new Plant("杜鹃", "red");
        Plant p2 = new Plant("玫瑰", "yellow");
        Plant p3 = new Plant("月季", "pink");
        Plant p4 = new Plant("荷花", "white");
        List<Plant> plantList = new ArrayList<>();
        plantList.add(p1);
        plantList.add(p2);
        plantList.add(p3);
        System.out.println("plants = " + plantList);

        // 使用addAll()方法进行复制
        List<Plant> plantsCopy = List.copyOf(plantList);
        System.out.println("plantsCopy = " + plantsCopy);

        // 向复制的列表添加新的元素，会报错
        //plantsCopy.add(p4); // UnsupportedOperationException

        // 修改列表中一个元素的属性，会同步体现到两个list上
        plantsCopy.get(0).setColor("white");
        System.out.println("Modified plants = " + plantList);
        System.out.println("Modified plantsCopy = " + plantsCopy);
    }
}
