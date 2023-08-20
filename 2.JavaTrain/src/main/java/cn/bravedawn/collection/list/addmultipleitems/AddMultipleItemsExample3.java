package cn.bravedawn.collection.list.addmultipleitems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/21 17:04
 */
public class AddMultipleItemsExample3 {

    /**
     * 使用Java8 Stream forEachOrdered()
     */

    public static void main(String[] args) {
        Plant p1 = new Plant("杜鹃", "red");
        Plant p2 = new Plant("玫瑰", "yellow");
        Plant p3 = new Plant("月季", "pink");
        Plant p4 = new Plant("兰花", "blue");

        List<Plant> source = new ArrayList<>(Arrays.asList(p1, p2));
        List<Plant> target = new ArrayList<>();
        // 这个方法会保证source列表的顺序，轮流去执行添加操作
        source.stream().forEachOrdered(target::add);
        System.out.println(target);

        System.out.println("---------------------------------------");
        List<Plant> source2 = new ArrayList<>(Arrays.asList(p1, p2, p3, p4));
        List<Plant> target2 = new ArrayList<>();

        // 使用stream的好处可以使用skip操作，执行跳过
        source2.stream().skip(1).forEachOrdered(target2::add);
        System.out.println(target2);


        System.out.println("---------------------------------------");
        List<Plant> source3 = new ArrayList<>(Arrays.asList(p1, p2, p3, p4));
        List<Plant> target3 = new ArrayList<>();
        // 使用stream的好处可以使用filter操作，执行过滤
        source3.stream().filter(p -> !(p.getColor().equals("pink"))).forEachOrdered(target3::add);
        System.out.println(target3);
    }



}
