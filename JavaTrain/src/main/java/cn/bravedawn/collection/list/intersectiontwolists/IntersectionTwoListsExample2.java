package cn.bravedawn.collection.list.intersectiontwolists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/26 7:59
 */
public class IntersectionTwoListsExample2 {

    /**
     * list的contains方法的底层实现就是对象的equals方法
     */

    public static void main(String[] args) {

        Plant p1 = new Plant("玫瑰", "red");
        Plant p2 = new Plant("百合", "white");
        Plant p3 = new Plant("牡丹", "yellow");
        Plant p4 = new Plant("杜鹃", "purple");
        Plant p5 = new Plant("月季", "pink");


        List<Plant> list = new ArrayList<>(Arrays.asList(p1, p2, p3));
        List<Plant> otherList = new ArrayList<>(Arrays.asList(p3, p4, p5));

        Set<Plant> result = list.stream()
                .distinct()
                .filter(otherList::contains)
                .collect(Collectors.toSet());

        System.out.println(result); // [Plant{name='牡丹', color='yellow'}]
    }

}
