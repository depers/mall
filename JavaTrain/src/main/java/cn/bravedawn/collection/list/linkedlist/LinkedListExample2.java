package cn.bravedawn.collection.list.linkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/9 17:30
 */
public class LinkedListExample2 {


    public static void main(String[] args) {

        // 创建
        LinkedList<Integer> list = new LinkedList<>();

        // 添加元素
        list.add(1);
        list.addAll(List.of(2, 3));

        // 在
        list.addFirst(4);
        list.addLast(5);
        System.out.println(list); // [4, 1, 2, 3, 5]

        // 移除元素

        // 队列操作

    }
}
