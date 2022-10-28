package cn.bravedawn.collection.jcf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/27 16:01
 */
public class CollectionsExample4 {

    /**
     * 在集合中进行搜索
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

        // Sort the List
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
