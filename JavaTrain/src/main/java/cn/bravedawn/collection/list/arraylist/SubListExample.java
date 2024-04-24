package cn.bravedawn.collection.list.arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/2 14:23
 */
public class SubListExample {


    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        stringList.add("e");

        List<String> list1 = stringList.subList(0, 2);
        System.out.println(list1);

        List<String> list2 = stringList.subList(2, 5);
        System.out.println(list2);
    }
}
