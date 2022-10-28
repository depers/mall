package cn.bravedawn.collection.jcf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/27 15:59
 */
public class CollectionsExample3 {

    /**
     * 对集合中的元素进行排序，Collections.sort()
     */

    public static void main(String[] args) {
        // Creating a list
        // Declaring object of string type
        List<String> items = new ArrayList<>();

        // Adding elements to the list
        // using add() method
        items.add("Shoes");
        items.add("Toys");

        // Adding one or more elements using addAll()
        Collections.addAll(items, "Fruits", "Bat", "Mouse");

        // Sorting according to default ordering
        // using sort() method
        Collections.sort(items);

        // Printing the elements
        for (int i = 0; i < items.size(); i++) {
            System.out.print(items.get(i) + " ");
        }

        System.out.println();

        // Sorting according to reverse ordering
        Collections.sort(items, Collections.reverseOrder());

        // Printing the reverse order
        for (int i = 0; i < items.size(); i++) {
            System.out.print(items.get(i) + " ");
        }
    }
}
