package cn.bravedawn.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListExample {


    /**
     * List的创建
     */

    public static void main(String[] args) {
        List list = new ArrayList();

        List list2 = new LinkedList();

        // 返回一个不可改变列表
        List list3 = List.of(1, 2, 4);

        // java.util.Arrays.ArrayList，而非java.util.ArrayList
        List list4 = Arrays.asList(1, 2, 4);
    }
}
