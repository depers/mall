package cn.bravedawn.collection.list.copylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/19 13:20
 */
public class CopyListExample4 {

    /**
     * 拷贝列表中的元素到另一个列表：第四种方法是使用Java8 stream，他除了拷贝外还提供了skip()和filter()等功能
     */

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "b", "c", "d");
        List<String> copy = list.stream().collect(Collectors.toList());
        System.out.println(copy); // [apple, b, c, d]

        List<String> copy2 = list.stream().skip(1).collect(Collectors.toList());
        System.out.println(copy2); // [b, c, d]

        List<String> copy3 = list.stream().filter(s -> s.length() > 1).collect(Collectors.toList());
        System.out.println(copy3); // [apple]

        //--------------------------------------------------------

        /**
         * 对于可变类，复制之后对原列表的修改，会同步体现到复制后的列表上
         */
        Plant p1 = new Plant("杜鹃", "red");
        Plant p2 = new Plant("玫瑰", "yellow");
        Plant p3 = new Plant("月季", "pink");
        List<Plant> plantList = new ArrayList<>();
        plantList.add(p1);
        plantList.add(p2);
        plantList.add(p3);
        System.out.println("plants = " + plantList);

        // 使用stream.toList()方法进行复制
        List<Plant> plantsCopy = plantList.stream().toList();
        System.out.println("plantsCopy = " + plantsCopy);

        // 修改列表中一个元素的属性
        plantsCopy.get(1).setColor("white");
        System.out.println("Modified plants = " + plantList);
        System.out.println("Modified plantsCopy = " + plantsCopy);

    }
}
