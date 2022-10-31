package cn.bravedawn.collection.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/31 18:09
 */
public class CollectionsDisjointExample {

    /**
     * 用于检查两个指定的集合是否不相交。
     * 更正式地说，如果两个集合没有共同的元素，则它们是不相交的。如果两个集合没有任何共同元素，则返回 true。
     */

    public static void main(String[] args) {
        // Create list1
        List<String> list1 = new ArrayList<>();

        // Add elements to list1
        list1.add("Shoes");
        list1.add("Toys");
        list1.add("Horse");
        list1.add("Tiger");

        // Create list2
        List<String> list2 = new ArrayList<>();

        // Add elements to list2
        list2.add("Bat");
        list2.add("Frog");
        list2.add("Lion");

        // Check if disjoint or not
        System.out.println(
                Collections.disjoint(list1, list2));
    }
}
