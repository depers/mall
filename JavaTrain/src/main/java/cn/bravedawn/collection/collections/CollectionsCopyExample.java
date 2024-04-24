package cn.bravedawn.collection.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/27 16:16
 */
public class CollectionsCopyExample {

    /**
     * 复制元素
     * 值得注意的是：
     * 1.目标列表中每个复制元素的索引将与其在源列表中的索引相同。
     * 2.目标列表必须至少与源列表一样长。如果它更长，则目标列表中的其余元素不受影响。
     */

    public static void main(String[] args) {
        // Create destination list
        List<String> destination_List = new ArrayList<>();

        // Add elements
        destination_List.add("Shoes");
        destination_List.add("Toys");
        destination_List.add("Horse");
        destination_List.add("Tiger");

        // Print the elements
        System.out.println(
                "The Original Destination list is ");

        for (int i = 0; i < destination_List.size(); i++) {
            System.out.print(destination_List.get(i) + " ");
        }
        System.out.println();

        // Create source list
        List<String> source_List = new ArrayList<>();

        // Add elements
        source_List.add("Bat");
        source_List.add("Frog");
        source_List.add("Lion");

        // Copy the elements from source to destination
        Collections.copy(destination_List, source_List);

        // Printing the modified list
        System.out.println(
                "The Destination List After copying is ");

        for (int i = 0; i < destination_List.size(); i++) {
            System.out.print(destination_List.get(i) + " ");
        }
    }
}
