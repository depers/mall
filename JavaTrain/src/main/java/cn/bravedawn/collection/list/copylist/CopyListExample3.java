package cn.bravedawn.collection.list.copylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/19 13:14
 */
public class CopyListExample3 {

    /**
     * 拷贝列表中的元素到另一个列表：第三种方法使用Collections.copy()方法
     */

    public static void main(String[] args) {

        // 长度一致，source中的元素会按照下标顺序覆盖目标列表
        List<Integer> source = Arrays.asList(1, 2, 3);
        List<Integer> dest = Arrays.asList(4, 5, 6);
        Collections.copy(dest, source);
        System.out.println("dest = " + dest); // [1, 2, 3]


        // 长度不一致，source中的元素会按照下标顺序覆盖目标列表，目标列表其余元素不变
        List<Integer> source2 = Arrays.asList(1, 2, 3);
        List<Integer> dest2 = Arrays.asList(4, 5, 6, 7, 8, 9, 10);
        Collections.copy(dest2, source2);
        System.out.println("dest2 = " + dest2); // [1, 2, 3, 7, 8, 9, 10]


        //-----------------------------------------------------------

        /**
         * 若复制的目标list的size小于0会报下面的错误
         */

        Plant p1 = new Plant("杜鹃", "red");
        Plant p2 = new Plant("玫瑰", "yellow");
        Plant p3 = new Plant("月季", "pink");
        List<Plant> plantList = new ArrayList<>();
        plantList.add(p1);
        plantList.add(p2);
        plantList.add(p3);
        System.out.println("plants = " + plantList);

        // 复制
        List<Plant> plantsCopy = new ArrayList<>(Arrays.asList(new Plant[2])); // size = 2
        // Collections.copy(plantsCopy, plantList); // java.lang.IndexOutOfBoundsException: Source does not fit in dest
        System.out.println("plantsCopy = " + plantsCopy);


        //-----------------------------------------------------------

        /**
         * Collections.copy也是浅复制
         */
        List<Plant> plantsCopy2 = new ArrayList<>(Arrays.asList(new Plant[plantList.size()]));
        System.out.println(plantsCopy2.size());
        Collections.copy(plantsCopy2, plantList);
        // 修改列表中一个元素的属性，会同步体现在两个列表中
        plantsCopy2.get(1).setColor("white");
        System.out.println("Modified plants = " + plantList);
        System.out.println("Modified plantsCopy = " + plantsCopy2);



    }
}
