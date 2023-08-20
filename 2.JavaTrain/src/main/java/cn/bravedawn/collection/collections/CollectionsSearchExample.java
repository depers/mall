package cn.bravedawn.collection.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/27 16:01
 */
public class CollectionsSearchExample {

    /**
     * 在集合中进行搜索
     * 注意：使用binarySearch()方法之前必须先要按照升序进行排序
     */

    public static void main(String[] args) {

        // Creating a List
        // Declaring object of string type
        List<String> items = new ArrayList<>();

        // Adding elements to object
        // using add() method
        items.add("Shoes");
        items.add("Toys");
        items.add("Horse");
        items.add("Ball");
        items.add("Grapes");

        // Sort the List，使用binarySearch()方法之前必须先要按照升序进行排序
        Collections.sort(items);
        System.out.println(items);

        // BinarySearch on the List
        System.out.println(
                "The index of Horse is "
                        + Collections.binarySearch(items, "Horse"));

        // BinarySearch on the List
        System.out.println(
                "The index of Dog is "
                        + Collections.binarySearch(items, "Dog"));

    }
}
