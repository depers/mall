package cn.bravedawn.collection.list.copylist;

import java.util.ArrayList;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/17 16:52
 */
public class CopyListExample {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> copy = new ArrayList<>(list);
        System.out.println(list.equals(copy));

    }

}
