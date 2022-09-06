package cn.bravedawn.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListExample5 {

    /**
     * list的切分操作
     */


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        int totalSize = list.size();

        System.out.println(list.subList(0, 0)); // []
        System.out.println(list.subList(0, 0).isEmpty()); // true
        System.out.println(list.subList(0, 0) == null); // false
        System.out.println(list.subList(0, 2)); // [1, 2]
        System.out.println(list.subList(0, totalSize)); // [1, 2, 3, 4, 5]
    }
}
