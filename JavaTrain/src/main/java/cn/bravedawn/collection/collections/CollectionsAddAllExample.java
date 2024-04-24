package cn.bravedawn.collection.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/27 15:55
 */
public class CollectionsAddAllExample {

    /**
     * 添加元素到集合中，Collections.addAll()
     */

    public static void main(String[] args) {
        // Creating a list
        // Declaring object of string type
        List<String> items = new ArrayList<>();

        // Adding elements (items) to the list
        items.add("Shoes");
        items.add("Toys");

        // Add one or more elements
        Collections.addAll(items, "Fruits", "Bat", "Ball");

        // Printing the list contents
        for (int i = 0; i < items.size(); i++) {
            System.out.print(items.get(i) + " ");
        }
    }
}
